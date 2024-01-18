package com.example.kotlin4_not.presentation.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlin4_not.R
import com.example.kotlin4_not.databinding.FragmentHomeBinding
import com.example.kotlin4_not.presentation.ui.adapters.NoteAdapter
import com.example.noteapp.App

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private var noteAdapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val noteDao = App.database.noteDao()
        val allNotes = noteDao?.getAllNotes()
        allNotes?.let {
            noteAdapter.setNoteList(allNotes)

            _binding?.rvNotes?.adapter = noteAdapter

        }
        onClick()
    }

    private fun onClick() = with(binding) {
        btnHomeFragment.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
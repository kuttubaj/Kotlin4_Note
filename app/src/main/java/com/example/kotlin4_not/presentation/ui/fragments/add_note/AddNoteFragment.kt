package com.example.kotlin4_not.presentation.ui.fragments.add_note

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlin4_not.R
import com.example.kotlin4_not.data.local.room.entites.Note
import com.example.kotlin4_not.databinding.FragmentAddNoteBinding
import com.example.noteapp.App
import java.time.LocalDate
import java.util.Date

class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null
    private val binding: FragmentAddNoteBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun onClick() = with(binding) {
        textEtNote.setOnClickListener {
            findNavController().navigate(R.id.action_addNoteFragment_to_homeFragment)
            val title = etAddNoteFirst.text.trim().toString()
            val description = etAddNoteSecond.text.trim().toString()
            val date = LocalDate.now()
            App.database.noteDao()?.addNote(
                Note(
                    title = title,
                    description = description,
                    date = "${date.dayOfMonth} ${date.month.name} \n  ${Date().hours}:${Date().minutes}"
                )
            )
        }
    }
}
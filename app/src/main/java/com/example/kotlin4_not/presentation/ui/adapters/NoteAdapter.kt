package com.example.kotlin4_not.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin4_not.data.models.NotesModel
import com.example.kotlin4_not.databinding.NoteItemBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var noteList = mutableListOf<NotesModel>()

    fun setNoteList(noteList: MutableList<NotesModel>) {
        this.noteList = noteList
    }

    class NoteViewHolder(private val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(notesModel: NotesModel) {
            binding.tvNote.text = notesModel.note
            binding.tvTitleNote.text = notesModel.title
            binding.tvDataTime.text = notesModel.data

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(noteList[position])
    }
}
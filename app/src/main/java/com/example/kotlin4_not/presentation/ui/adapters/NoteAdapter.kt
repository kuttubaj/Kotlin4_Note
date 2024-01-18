package com.example.kotlin4_not.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin4_not.data.local.room.entites.Note
import com.example.kotlin4_not.data.models.NotesModel
import com.example.kotlin4_not.databinding.NoteItemBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var noteList = listOf<Note>()
    fun setNoteList(noteList: List<Note>) {
        this.noteList = noteList
    }

    class NoteViewHolder(private val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(notesModel: Note) {
            binding.tvNote.text = notesModel.description
            binding.tvTitleNote.text = notesModel.title
            binding.tvDataTime.text = notesModel.date.toString()

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
package com.memorizer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.memorizer.R;
import com.memorizer.entity.Word;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    private List<Word> words;

    public WordAdapter(){
        words = new ArrayList<>();
    }

    public void setWords(List<Word> words){
        if(!this.words.isEmpty()) this.words.clear();

        this.words.addAll(words);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.word_item_view, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Word word = words.get(position);
        holder.bind(word);
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        private TextView wordTextView;
        private TextView translateTextView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);

            wordTextView = itemView.findViewById(R.id.word_text_view);
            translateTextView = itemView.findViewById(R.id.translated_text_view);
        }

        public void bind(Word word) {
            wordTextView.setText(word.getWord());
            translateTextView.setText(word.getTranslation());
        }
    }
}

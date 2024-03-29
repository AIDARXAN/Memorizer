package com.memorizer.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.memorizer.App;
import com.memorizer.R;
import com.memorizer.db.AppDatabase;
import com.memorizer.entity.Word;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    private List<Word> words;
    private AppDatabase appDatabase = App.getAppDatabase();

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
        View view = LayoutInflater.from(context).inflate(R.layout.word_item_view,
                                                         parent,
                                              false);
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
        private TextView transcriptTextView;
        private Button deleteButton;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordTextView = itemView.findViewById(R.id.word_text_view);
            translateTextView = itemView.findViewById(R.id.translated_text_view);
            transcriptTextView = itemView.findViewById(R.id.transcript_text_view);
            deleteButton = itemView.findViewById(R.id.button_delete);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteItem(getAdapterPosition());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    updateItemType(getAdapterPosition());
                    return true;
                }
            });

        }

        public void bind(Word word) {
            wordTextView.setText(word.getWord());
            translateTextView.setText(word.getTranslation());
            transcriptTextView.setText(word.getTranscription());
        }
    }

    public void deleteItem(int position) {
        Word word = words.get(position);
        words.remove(position);
        notifyItemRemoved(position);

        deleteWordFromDatabase(word);
    }

    public void updateItemType(int position){
        Word word = words.get(position);
        words.remove(position);
        notifyItemRemoved(position);
        word.setType(2);

        updateWordInDatabase(word);
    }

    public void deleteWordFromDatabase(final Word word){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.getWordDao().delete(word);
                return null;
            }
        }.execute();
    }
    public void updateWordInDatabase(final Word word){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.getWordDao().update(word);
                return null;
            }
        }.execute();
    }

}

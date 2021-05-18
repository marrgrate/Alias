package com.example.alias.presenter.Dictionary;

import android.content.Intent;
import android.widget.ListView;
import com.example.alias.offline.model.Game;

public class DictionariesPresenter {
    DictionariesView view;
    Game game = new Game();
    DictionaryRepository repo;

    public DictionariesPresenter(DictionariesView v, DictionaryRepository repo){
        this.view = v;
        this.repo = repo;
    }


    public void putExtra(Intent intent){
        intent.putExtra("game", game);
    }

    public void getExtra(Intent intent){
        game = (Game) intent.getSerializableExtra("game");
    }

    public Intent onNextClick(Intent intent){
        return intent.putExtra("game", game);
    }

    public void setSelected(ListView dictionariesListView){
        game.setDictionarySelected(dictionariesListView.getSelectedItem().toString());
    }

    void onFinish(){
        view.showDictionaries( repo.getDictionaries());
        view.onButtonClick();
    }

    public void onDestroy(){
        view = null;
    }
}

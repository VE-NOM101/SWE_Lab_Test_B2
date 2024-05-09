package com.example.labtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


class info{
    protected int units;
    protected String genre_name;
}

class genre{
    protected ArrayList<String> Mystery= new ArrayList<>();

    protected ArrayList<String> Fantasy=new ArrayList<>();

    protected ArrayList<String> Thriller=new ArrayList<>();

    public String show_book_info_by_genre(String g){
        String d= new String();
        if(g.equals("mystery")){
            for(int i=0;i<Mystery.size();i++){
                d+=Mystery.get(i)+" ";
            }
        }
        if(g.equals("fantasy")){
            for(int i=0;i<Fantasy.size();i++){
                d+=Fantasy.get(i)+" ";
            }
        }
        if(g.equals("thriller")){
            for(int i=0;i<Thriller.size();i++){
                d+=Thriller.get(i)+" ";
            }
        }

        return d;
    }
}
class book extends genre{
    protected String title;
    protected  info infoObj=new info();
    protected String author;
    public void add_book (String t, String a, String g, int u){
        this.title=t;
        this.author=a;
        this.infoObj.genre_name=g;
        this.infoObj.units+=u;
        if(g.equals("mystery")){
            Mystery.add(t);
        }
        if(g.equals("fantasy")){
            Fantasy.add(t);
        }
        if(g.equals("thriller")){
            Thriller.add(t);
        }
    }
    public void borrow_book (String t,int u){
        this.infoObj.units-=u;
        if(infoObj.genre_name.equals("mystery")){

        }
        if(infoObj.genre_name.equals("fantasy")){
        }
        if(infoObj.genre_name.equals("thriller")){

        }
    }
}



public class MainActivity extends AppCompatActivity {
    book bookObj = new book();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText title = findViewById(R.id.title);
        EditText author = findViewById(R.id.author);
        EditText genre = findViewById(R.id.genre);
        EditText units = findViewById(R.id.units);

        TextView display = findViewById(R.id.display);
        Button add = findViewById(R.id.add_book);
        Button borrow = findViewById(R.id.borrow_book);
        Button show = findViewById(R.id.show);
        TextView listView = findViewById(R.id.listView);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = title.getText().toString();
                String a = author.getText().toString();
                String g = genre.getText().toString();
                Integer u = Integer.parseInt(units.getText().toString());

                bookObj.add_book(t,a,g,u);
                display.setText(t +" "+ a +" "+g+" "+u );
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setText(bookObj.show_book_info_by_genre(genre.getText().toString()));
            }
        });


    }
}
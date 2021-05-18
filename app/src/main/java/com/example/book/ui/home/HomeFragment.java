package com.example.book.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.MainActivity;
import com.example.book.R;
import com.example.book.databinding.FragmentHomeBinding;
import com.example.book.ui.Recycle.BookAdapter;
import com.example.book.ui.Recycle.BookItem;
import com.example.book.ui.test.MyAdapter;
import com.example.book.ui.test.MyListDecoration;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    View rootView;
    MainActivity activity;
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private RecyclerView listview;

    RecyclerView recyclerView;
    BookAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        initBookAdapter();
        //init();
        return rootView;
    }
   public void initBookAdapter(){
        recyclerView = (RecyclerView) rootView.findViewById(R.id.main_listview);
       LinearLayoutManager layoutManager = new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false);
       recyclerView.setLayoutManager(layoutManager);
        adapter = new BookAdapter(getActivity());
        adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210408_253/1617845912408vuzAQ_JPEG/movie_image","왜"));
       adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210408_253/1617845912408vuzAQ_JPEG/movie_image.jpg","안됌"));
       adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210408_253/1617845912408vuzAQ_JPEG/movie_image.jpg","왜1"));
       adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210408_253/1617845912408vuzAQ_JPEG/movie_image.jpg?type=m427_320_2","2231"));
       adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210408_253/1617845912408vuzAQ_JPEG/movie_image.jpg?type=m427_320_2","12213"));

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BookAdapter.ViewHolder holder, View view, int position) {
                BookItem item = adapter.getItem(position);
                Toast.makeText(activity,"select item: "+item.getBookName(),Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();


    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }
    private void init() {

        listview = (RecyclerView) rootView.findViewById(R.id.main_listview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(  activity, LinearLayoutManager.HORIZONTAL, false); //가로 방향 설정
        listview.setLayoutManager(layoutManager);

        ArrayList<String> itemList = new ArrayList<>();
        itemList.add("0");
        itemList.add("1");
        itemList.add("2");
        itemList.add("3");
        itemList.add("4");
        itemList.add("5");
        itemList.add("6");
        itemList.add("7");
        itemList.add("8");
        itemList.add("9");
        itemList.add("10");
        itemList.add("11");

//        adapter = new MyAdapter(activity, itemList, onClickItem);
        listview.setAdapter(adapter);

        MyListDecoration decoration = new MyListDecoration();
        listview.addItemDecoration(decoration);
    }


    private View.OnClickListener onClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = (String) v.getTag();
            Toast.makeText(activity, str, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.book.ui.home;

import android.content.Context;
import android.content.Intent;
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

import com.example.book.BookActivity;
import com.example.book.MainActivity;
import com.example.book.R;
import com.example.book.data.BookData;
import com.example.book.databinding.FragmentHomeBinding;
import com.example.book.ui.Recycle.BookAdapter;
import com.example.book.ui.Recycle.BookItem;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    View rootView;
    MainActivity activity;
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;


    RecyclerView recyclerView;
    BookAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        initBookAdapter();
        initBookAdapter2();
        initBookAdapter3();
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101){
            String name = data.getStringExtra("name");
            Toast.makeText(activity,"메뉴화면으로부터 응답: "+ name,Toast.LENGTH_LONG).show();
        }
    }

    public void initBookAdapter(){
        recyclerView = (RecyclerView) rootView.findViewById(R.id.main_listview);
       LinearLayoutManager layoutManager = new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false);
       recyclerView.setLayoutManager(layoutManager);
        adapter = new BookAdapter(getActivity());
        adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210408_253/1617845912408vuzAQ_JPEG/movie_image","국방1"));
       adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210408_253/1617845912408vuzAQ_JPEG/movie_image.jpg","국방2"));
       adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210408_253/1617845912408vuzAQ_JPEG/movie_image.jpg","국방3"));
       adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210408_253/1617845912408vuzAQ_JPEG/movie_image.jpg?type=m427_320_2","국방4"));
       adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210408_253/1617845912408vuzAQ_JPEG/movie_image.jpg?type=m427_320_2","국방5"));

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BookAdapter.ViewHolder holder, View view, int position) {
                BookItem item = adapter.getItem(position);
                Toast.makeText(activity,"select item: "+item.getBookName(),Toast.LENGTH_LONG).show();
                //시스템 요청
                Intent intent = new Intent(activity, BookActivity.class);
                ArrayList<String> names = new ArrayList<String>();
                names.add("김종민");
                names.add("손상훈");
                intent.putExtra("names", names);

                BookData data = new BookData(100,"Hello");
                intent.putExtra("data",data);
                startActivityForResult(intent,101);

            }
        });

    }
    public void initBookAdapter2(){
        recyclerView = (RecyclerView) rootView.findViewById(R.id.main_listview2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BookAdapter(getActivity());
        adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210422_65/1619057290509eebFd_JPEG/movie_image.jpg?type=m427_320_2","네이버1"));
        adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210422_65/1619057290509eebFd_JPEG/movie_image.jpg?type=m427_320_2","네이버2"));
        adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210422_65/1619057290509eebFd_JPEG/movie_image.jpg?type=m427_320_2","네이버3"));
        adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210422_65/1619057290509eebFd_JPEG/movie_image.jpg?type=m427_320_2","네이버4"));
        adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210422_65/1619057290509eebFd_JPEG/movie_image.jpg?type=m427_320_2","네이버5"));

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BookAdapter.ViewHolder holder, View view, int position) {
                BookItem item = adapter.getItem(position);
                Toast.makeText(activity,"select item: "+item.getBookName(),Toast.LENGTH_LONG).show();
                //시스템 요청
                Intent intent = new Intent(activity, BookActivity.class);

                //그냥 데이터 대충 넘기는 경우
                ArrayList<String> names = new ArrayList<String>();
                names.add("네이버2");
                names.add("네이버3");
                intent.putExtra("names", names);

                //데이터 용량 줄여서 넘기는 경우
                BookData data = new BookData(100,"네이버1");
                intent.putExtra("data",data);
                startActivityForResult(intent,101);

            }
        });

    }
    public void initBookAdapter3(){
        recyclerView = (RecyclerView) rootView.findViewById(R.id.main_listview3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BookAdapter(getActivity());
        adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210422_63/1619057277707BCIPc_JPEG/movie_image.jpg?type=m427_320_2","다음1"));
        adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210422_63/1619057277707BCIPc_JPEG/movie_image.jpg?type=m427_320_2","다음2"));
        adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210422_63/1619057277707BCIPc_JPEG/movie_image.jpg?type=m427_320_2","다음3"));
        adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210422_63/1619057277707BCIPc_JPEG/movie_image.jpg?type=m427_320_2","다음4"));
        adapter.addItem(new BookItem("https://movie-phinf.pstatic.net/20210422_63/1619057277707BCIPc_JPEG/movie_image.jpg?type=m427_320_2","다음5"));

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BookAdapter.ViewHolder holder, View view, int position) {
                BookItem item = adapter.getItem(position);
                Toast.makeText(activity,"select item: "+item.getBookName(),Toast.LENGTH_LONG).show();
                //시스템 요청
                Intent intent = new Intent(activity, BookActivity.class);
                ArrayList<String> names = new ArrayList<String>();
                names.add("다음다음");
                names.add("다음다음다음");
                intent.putExtra("names", names);

                BookData data = new BookData(100,"다음");
                intent.putExtra("data",data);
                startActivityForResult(intent,101);

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
package com.example.book.ui.Network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class ImageLoadTask extends AsyncTask<Void,Void, Bitmap> {
    private String urlStr;
    private ImageView imageView;
//메모리 꽉차는 거 방지, 이전 비트맵을 메모리에서 없애주는 역할
    private static HashMap<String, Bitmap> bitmapHash = new HashMap<String, Bitmap>();
public ImageLoadTask(String urlStr, ImageView imageView){
    this.urlStr = urlStr;
    this.imageView = imageView;
}
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected Bitmap doInBackground(Void... voids) {
        Bitmap bitmap = null;
        try {
//            if(bitmapHash.containsKey(urlStr)){
//                Bitmap oldBitmap = bitmapHash.remove(urlStr);
//                if(oldBitmap != null&& !oldBitmap.isRecycled()){
//                    oldBitmap.recycle();
//                    oldBitmap = null;
//                }
//            }
            URL url = new URL(urlStr);
             bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());

//             bitmapHash.put(urlStr,bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
        imageView.invalidate();
    }


}

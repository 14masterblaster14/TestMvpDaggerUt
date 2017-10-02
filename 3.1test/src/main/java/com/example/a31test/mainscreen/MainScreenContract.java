package com.example.a31test.mainscreen;


import com.example.a31test.data.Post;

import java.util.List;

/**
 * Created by Aditya on 11-May-16.
 */
public interface MainScreenContract {
    interface View {
        void showPosts(List<Post> posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}

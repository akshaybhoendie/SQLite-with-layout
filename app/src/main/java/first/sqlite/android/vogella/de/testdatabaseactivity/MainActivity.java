package first.sqlite.android.vogella.de.testdatabaseactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.Random;

import first.sqlite.android.vogella.de.testdatabaseactivity.dao.CommentDataSource;
import first.sqlite.android.vogella.de.testdatabaseactivity.dto.Comment;

public class MainActivity extends ListActivity {
        private CommentDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new CommentDataSource(this);
        dataSource.open();

        List<Comment> values = dataSource.getAllComments();

        // use the simplecursor adapter to show the elements in listview
        ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this, android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

        public void onClick(View view){
            ArrayAdapter<Comment> adapter = (ArrayAdapter <Comment>) getListAdapter();
            Comment comment = null;
            switch (view.getId()){
                case R.id.add:
                        String[] comments = new String[]{"Cool", "Very nice", "Hate it"};
                        int nextInt = new Random().nextInt(3);
                    // save the comments to database
                    comment = dataSource.createComment(comments[nextInt]);
                    adapter.add(comment);
                    break;
                case R.id.delete:
                        if(getListAdapter().getCount()>0){
                            comment = (Comment) getListAdapter().getItem(0);
                            dataSource.deleteComment(comment);
                            adapter.remove(comment);
                        }
                    break;
            }
             adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume(){
        dataSource.open();
        super.onResume();
    }

    protected void onPause(){
        dataSource.close();
        super.onPause();
    }




}

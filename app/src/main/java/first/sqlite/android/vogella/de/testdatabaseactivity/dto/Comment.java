package first.sqlite.android.vogella.de.testdatabaseactivity.dto;

/**
 * Created by abhoendie on 2/16/2017.
 */

public class Comment {

    private long id;
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // will be used by the Arrayadapter in the ListView
    @Override
    public String toString(){
        return comment;
    }
}

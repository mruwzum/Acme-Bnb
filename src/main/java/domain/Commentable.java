package domain;

import java.util.Collection;


public interface Commentable {
    Collection<Comment> getComments();

    void setComments(Collection<Comment> comments);

}

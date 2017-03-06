package domain;

import java.util.Collection;

/**
 * Created by daviddelatorre on 5/3/17.
 */
public interface Commentable {
    Collection<Comment> getComments();

    void setComments(Collection<Comment> comments);

}

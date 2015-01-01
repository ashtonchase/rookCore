package rookCore;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by ashton on 12/29/14.
 */
public interface CardHolderInterface {

     List<Card> viewCards();

     void releaseCardOut(byte CardIndex);


}

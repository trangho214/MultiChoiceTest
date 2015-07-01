package paxcreation.com.multipleviewinrecycleview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 30/06/2015.
 */
public class Data {

    public static Header getHeader()
    {
        Header header = new Header();
        header.setHeader("I'm header");
        return header;
    }

    public static List<ListItem> getListItems()
    {
        List<ListItem> listItems = new ArrayList<ListItem>();
        for (int i = 0; i<10; i++) {
            ListItem item = new ListItem();
            item.setName("image" + i);
            if (i % 2 == 0)
                item.setId(R.drawable.sweetlife);
            else
                item.setId(R.drawable.young);
            listItems.add(item);
        }
        return listItems;
    }
}

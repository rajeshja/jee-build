package rja.bean;

import java.util.List;

import rja.entities.Item;

/**
 * Describe interface ItemManager here.
 *
 *
 * Created: Tue Jun 16 19:53:08 2009
 *
 * @author <a href="mailto:rajeshja@GDYLPT13432"></a>
 * @version 1.0
 */
public interface ItemManager {

	void insert(Item item);

	List<Item> findAllItems();
}

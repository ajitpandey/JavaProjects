package com.ajit.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.ajit.xml.vo.Config;
import com.ajit.xml.vo.Item;
import com.thoughtworks.xstream.XStream;

public class XStreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//toXMl();
		fromXMl();
		
	}

	private static void toXMl() {
		XStream xstream = new XStream();
		xstream.alias("config", Config.class);
		xstream.alias("item", Item.class);
		
		Config config = new Config();
		List<Item> itemList = new ArrayList<Item>();
		Item item = new Item();
		item.setCurrent("current1");
		item.setMode("mode1");
		item.setDate("date1");
		item.setInteractive("interactive1");
		item.setUnit("unit1");
		itemList.add(item);
		
		item = new Item();
		item.setCurrent("current1");
		item.setMode("mode1");
		item.setDate("date1");
		item.setInteractive("interactive1");
		item.setUnit("unit1");
		itemList.add(item);
		
		config.setItemList(itemList);
		
		String configStr = xstream.toXML(config);
		
		System.out.println(configStr);
	}

	private static void fromXMl() {
		XStream xstream = new XStream();
		xstream.alias("config", Config.class);
		xstream.alias("item", Item.class);
		
		Config config = (Config)xstream.fromXML(new File("gen_config.xml"));
		
		System.out.println(config.getItemList().size());
		for(Item itm : config.getItemList()){
			System.out.println(itm.getCurrent());
		}
	}

}

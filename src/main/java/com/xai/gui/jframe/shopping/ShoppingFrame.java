package com.xai.gui.jframe.shopping;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShoppingFrame extends JFrame {

	private JLabel itemLabel;
	
	//custom
	private String receiptOutputFile = "res/files/writeOldMethod.txt";
	
	private JLabel itemPriceLabel;
	private JLabel itemCatNumberLabel;
	private JTextArea itemDescription;
	private ImageIcon itemImageIcon;
	private JLabel itemImageLabel;
	
	private JButton nextItemBtn;
	private JButton previousItemBtn;
	private JButton addToCartBtn;
	private JButton checkOutBtn;
	private ActionListener itemListener;
	private ActionListener addToCartListener;
	private ActionListener checkOutListener;
	
	private Store store;
	private Customer cust;
	
	private int currentItemIndex;
	/**
	 * We pass a store that has all the items in it into the frame
	 * so that the frame can interact with the items
	 * @param store
	 */
	public ShoppingFrame(Store store, Customer cust){
		setTitle("My Online Store");
		this.store = store;
		this.cust = cust;
		init();	//helper method to keep construcor clean
		
	}
	
	/**
	 * helper method to init this class on creation
	 * The main initialization codes go here
	 */
	private void init(){
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(500, 200);
		
		//take care of loading the store items
		currentItemIndex = 0;
		
		//overall layout
		loadHeader();	//item price, catalogNumber, add to cart, checkout buttons
		loadBody();		//item image and description goes here
		loadFooter();	//prev and next button goes here
		displayCurrentItem();
	}
	
	private void loadHeader(){
		
		JPanel header = new JPanel(new BorderLayout());
		Color bgColor = new Color(8,8,74);	//dark blue
		header.setBackground(bgColor);
		
		//populate west and east panel onto header
		addHeaderWestPanel(header, bgColor);
		addHeaderEastPanel(header, bgColor);
		
		//put the header onto the frame's north section
		this.add(header, BorderLayout.NORTH);	//add this header panel to the jframe's north end
		
		//a sub panel that holds the buttons if you want
		/*
		JPanel panel = new JPanel(new FlowLayout()){
			@Override
			public void paintComponent(Graphics g){
				super.paintComponent(g);
                g.setColor(Color.BLUE);
                g.fillRect(0,0, 200,100);
			}
		};
		panel.setSize(200, 100 );
		*/
		
	}
	
	//helper method for header to add west panel
	private void addHeaderWestPanel(JPanel header, Color bgColor){
		//-----------------------------------------------------------
		//west panel (price, catalogNumber)
		//-----------------------------------------------------------
		JPanel westPanel = new JPanel(new FlowLayout(0));
		westPanel.setBackground(bgColor);
		
		//Price
		itemPriceLabel = new JLabel();
		itemPriceLabel.setPreferredSize(new Dimension(70,25));
		applyMyCustomColorStyle(itemPriceLabel);
		westPanel.add(itemPriceLabel, BorderLayout.WEST);
		
		//Catalog
		itemCatNumberLabel = new JLabel();
		itemCatNumberLabel.setPreferredSize(new Dimension(100,25));
		applyMyCustomColorStyle(itemCatNumberLabel);
		westPanel.add(itemCatNumberLabel, BorderLayout.WEST);
		
		//add west panel
		header.add(westPanel, BorderLayout.WEST);
	}
	
	//helper method to add east panel to header
	private void addHeaderEastPanel(JPanel header, Color bgColor){
		//-----------------------------------------------------------
		//east panel (add to cart, check out, product description)
		//-----------------------------------------------------------
		JPanel eastPanel = new JPanel(new FlowLayout(0));
		eastPanel.setBackground(bgColor);
		
		//add to cart action listener
		addToCartListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//we don't want to just take the item from the array and pass it to the customer
				//otherwise we will have two ref pointing to the same item object
				//so we need to copy the item instead and create a new item from it
				
				//copy the display item
				CatalogItem currItem = store.catalogArray[currentItemIndex];
				
				//once we get the item, we have to do one check
				//is it a catalogItem or a clothingItem by checking against it's
				//catalog number to see if it starts with c
				if(currItem.getCatalogNumber().substring(0, 1).equalsIgnoreCase("c")){
					//don't bother casting, you cannot cast from parent to child
					//ClothingItem castedItem = (ClothingItem) currItem; //WRONG ERROR!!!
					
					//copy item instead using copy constructor
					ClothingItem copiedItem = new ClothingItem(currItem);
					
					//if it is a clothing item, prompt window and ask for size of clothing
					//the enter value is passed as a string into the item's size using setSize
					//jOptionPane handles the popup and user input
					copiedItem.setSize(inputSize());
					cust.addToShoppingCart(copiedItem);
				}else{
					CatalogItem copiedItem = new CatalogItem(currItem);
					cust.addToShoppingCart(copiedItem);
				}
				
			}
		};
		
		//add to cart button
		addToCartBtn = new JButton("Add To Cart");
		addToCartBtn.addActionListener(addToCartListener);
		eastPanel.add(addToCartBtn);	//add button to frame
		
		checkOutListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//print out a receipt to a file
				try {
					System.out.println("checking out");
					printReciept();
				} catch (IOException e1) {
					e1.printStackTrace();
					System.exit(0);	//exit my program if there is an exception error
				}
			}
		};
		
		//checkout button
		addToCartBtn = new JButton("Checkout");
		addToCartBtn.addActionListener(checkOutListener);
		eastPanel.add(addToCartBtn);	//add button to frame
		
		//add west panel
		header.add(eastPanel, BorderLayout.EAST);
	}
	
	//body or center
	private void loadBody(){
		JPanel body = new JPanel(new FlowLayout(0));
		body.setBackground(Color.GRAY);
		this.add(body, BorderLayout.CENTER);
		
		//item image
		itemImageIcon = new ImageIcon("res/images/icon1.png");
		itemImageLabel = new JLabel();
		itemImageLabel.setPreferredSize(new Dimension(50,50));
		itemImageLabel.setBackground(Color.BLACK);
		itemImageLabel.setIcon(itemImageIcon);
		body.add(itemImageLabel);
		
		//item description
		itemDescription = new JTextArea("desc", 3, 30);
		itemDescription.setEditable(false);
		itemDescription.setWrapStyleWord(true);
		itemDescription.setLineWrap(true);
		itemDescription.setMargin(new Insets(5,5,5,5));
		body.add(itemDescription);
		
		
		
	}
	
	private void loadFooter(){
		JPanel footer = new JPanel();
		footer.setBackground(Color.BLACK);
		
		//itemListener
		itemListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String btnType = ((JButton)e.getSource()).getText();
				
				if(btnType.equalsIgnoreCase("next")){
					//go next
					if(currentItemIndex < store.maxSize-1){
						currentItemIndex++;
						displayCurrentItem();
					}
					
				}else if(btnType.equalsIgnoreCase("prev")){
					//go back
					if(currentItemIndex > 0){
						currentItemIndex--;
						displayCurrentItem();
					}
				}
			}
		};
		
		//PREVIOUS BUTTON
		previousItemBtn = new JButton("Prev");
		previousItemBtn.addActionListener(itemListener);
		footer.add(previousItemBtn);	//add button to frame
		
		//NEXT BUTTON
		nextItemBtn = new JButton("Next");
		nextItemBtn.addActionListener(itemListener);
		footer.add(nextItemBtn);		//add button to frame
		
		this.add(footer, BorderLayout.SOUTH);
		
	}
	
	/**
	 * Responsible in updating the item onto the gui
	 * gets the current item and displays its information onto the text and labels
	 */
	private void displayCurrentItem(){
		//get the item here so we can reuse it within this scope
		CatalogItem currItem = store.catalogArray[currentItemIndex];
		itemPriceLabel.setText(" $" + currItem.getPrice());
		itemCatNumberLabel.setText(" # " + currItem.getCatalogNumber());
		itemDescription.setText(currItem.getDescription());
		
		//display the image we have to do some checks to make sure the item images exist before we display it
		ImageIcon newImage = new ImageIcon(currItem.getImgPath());
		//if it is a valid image, its properties field will not be null
		if(newImage.getImage().getProperty("properties", newImage.getImageObserver()) != null){
			itemImageLabel.setIcon(newImage);
		}else{
			//give it a default no image instead
			itemImageLabel.setIcon(new ImageIcon("res/images/noImg.png"));
		}
	}
	
	//handles apply some pretty colors to my gui
	private void applyMyCustomColorStyle(JLabel label){
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
	}
	
	//prints the receipt in a form of a text file
	private void printReciept() throws IOException {
		
		//make sure customer at least has one ore more items in cart
		if(cust.getNumItemsOrdered() > 0){
			
			//need file object to hold path
			File file = new File(receiptOutputFile);
			
			//need a writer class to write to the file
			PrintWriter p = new PrintWriter(file);
			
			//tell the printer to write something
			p.println(cust.getName());
			p.println(cust.getAddress());
			p.println(cust.getCity());
			p.println(cust.getState());
			p.println(cust.getZip());
			p.println();
			
			//print the item the customer bought
			for(int i=0; i<cust.getNumItemsOrdered(); i++){
				//get each item in customer's shopping car
				p.println(cust.shoppingCart[i]);
			}
			
			//save and close the file
			p.close();
			System.out.println("Receipt printed successfully");
		}else{
			System.out.println("No reciept was printed. Custom with empty cart");
			JOptionPane.showMessageDialog(null, "Your cart is empty, no recipt will be printed");
		}
	}
	
	/**
	 * When this method is call it prompts user to enter a size
	 * @return
	 */
	public String inputSize(){
		String size = "";
		//this will force the user to put something in for the size
		//this also prevents the user from clicking cancel
		while(size == null || size.equals("")){
			size = JOptionPane.showInputDialog(null, "Please Enter a Size (Required)");
		}
		return size;
	}
}

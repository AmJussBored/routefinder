import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dijkstra extends JFrame implements ActionListener, ItemListener
{
	int i, select, end;
	String Orderedpath= ""; 
	String [] listofdistrict = {"Choose a district:", "Karanes District", "Trost District", "Stohess District", "Shiganshina District", "Krolva District"};
	JLabel Title;
	JLabel Titlesub;
	JLabel TownFrom;
	JLabel TownTo;
	JLabel TravelTime;
	JLabel Route;
	JComboBox TownStart;
	JComboBox TownEnd;
	JButton btnStart;
	JButton btnClear;
	JButton btnClose;
	JButton btnTravel;
	JTextField txtTime;
	JTextField txtRoute;
	//Graph size location
	int [][] graph = new int[][] {{0,0,3,2,1},
		  						  {0,0,7,5,0},
		  						  {3,7,0,0,2},
		  						  {2,5,0,0,2},
		  						  {1,0,2,2,0}};
	
 public Dijkstra (String n) 
 {
	 //Name of the window UI
	 super (n);
	 getContentPane().setBackground(Color.LIGHT_GRAY);
	 getContentPane().setLayout(null);
	 
	 //Title UI
	 Title = new JLabel("Route Finder");
	 Title.setFont(new Font("Tahoma", Font.PLAIN, 35));
	 Title.setBounds(188, 11, 210, 32);
	 getContentPane().add(Title);
	 
	 //Title Sub label UI
	 Titlesub = new JLabel("(Using Djikstra Algorithm)");
	 Titlesub.setFont(new Font("Tahoma", Font.PLAIN, 15));
	 Titlesub.setBounds(208, 44, 169, 32);
	 getContentPane().add(Titlesub);
	 
	 //Town From UI
	 TownFrom = new JLabel("Which town are you from?");
	 TownFrom.setFont(new Font("Tahoma", Font.BOLD, 15));
	 TownFrom.setBounds(55, 143, 206, 24);
	 getContentPane().add(TownFrom);
	 
	 //Town where to go UI
	 TownTo = new JLabel("Where do you want to go?");
	 TownTo.setFont(new Font("Tahoma", Font.BOLD, 15));
	 TownTo.setBounds(55, 218, 200, 32);
	 getContentPane().add(TownTo);
	 
	 //Travel Label UI
	 TravelTime = new JLabel("Travel Time");
	 TravelTime.setFont(new Font("Tahoma", Font.BOLD, 15));
	 TravelTime.setBounds(76, 307, 102, 29);
	 getContentPane().add(TravelTime);
	 
	 //Route Label UI
	 Route = new JLabel("Route");
	 Route.setFont(new Font("Tahoma", Font.BOLD, 15));
	 Route.setBounds(103, 367, 46, 29);
	 getContentPane().add(Route);
	 
	 //TownStart Combo box UI
	 TownStart = new JComboBox(listofdistrict);
	 TownStart.setBounds(286, 145, 210, 24);
	 getContentPane().add(TownStart);
	 TownStart.addItemListener(this);
	 TownStart.setEnabled(false);
	 
	 //Town End Combo box UI
	 TownEnd = new JComboBox(listofdistrict);
	 TownEnd.setBounds(286, 225, 210, 22);
	 getContentPane().add(TownEnd);
	 TownEnd.addItemListener(this);
	 TownEnd.setEnabled(false);
	 
	 //Button Start UI
	 btnStart = new JButton("Start");
	 btnStart.setBounds(246, 96, 89, 24);
	 getContentPane().add(btnStart);
	 btnStart.addActionListener(this);
	 
	 //Button Clear UI
	 btnClear = new JButton("Clear");
	 btnClear.setBounds(246, 414, 89, 24);
	 getContentPane().add(btnClear);
	 btnClear.setEnabled(false);
	 btnClear.addActionListener(this);
	 
	 //Button Close UI
	 btnClose = new JButton("Close");
	 btnClose.setBounds(246, 518, 89, 32);
	 getContentPane().add(btnClose);
	 btnClose.addActionListener(this);
	 
	 //Button Travel UI
	 btnTravel = new JButton("Travel");
	 btnTravel.setBounds(246, 269, 89, 24);
	 getContentPane().add(btnTravel);
	 btnTravel.setEnabled(false);
	 btnTravel.addActionListener(this);
	 
	 //Time Text Field UI
	 txtTime = new JTextField();
	 txtTime.setBounds(188, 304, 326, 39);
	 getContentPane().add(txtTime);
	 txtTime.setColumns(10);
	 txtTime.setEditable(false);
	 
	 //Route Text field UI
	 txtRoute = new JTextField();
	 txtRoute.setBounds(188, 364, 326, 39);
	 getContentPane().add(txtRoute);
	 txtRoute.setColumns(10);
	 txtRoute.setEditable(false);
	 
	 //Window Size
	 setVisible(true);
	 setSize(600,600);
 }

//Buttons function
public void actionPerformed(ActionEvent x) 
 {
	 if(x.getSource()==btnStart)
			act_buttons();
	 else if(x.getSource()==btnClear)
		    clear();
	 else if(x.getSource() == btnTravel)
		    dijkstra(graph, select, end);
	 else if(x.getSource()==btnClose)
		    System.exit(0);
 }
 
//Combo box function
public void itemStateChanged(ItemEvent x)
 {
	 int start = TownStart.getSelectedIndex();
	 start = start -1;
	 if (start == 0)
	 {
		 select = 0;
	 }
	 
	 else if (start == 1)
	 {
		 select = 1;
	 }
	 
	 else if (start == 2)
	 {
		 select = 2;
	 }
	 
	 else if (start == 3)
	 {
		 select = 3;
	 }
	 
	 else if (start == 4)
	 {
		 select = 4;
	 }
	 
	 int tend = TownEnd.getSelectedIndex();
	 tend = tend -1;
	 if (tend == 0)
	 {
		 end = 0;
	 }
	 
	 else if (tend == 1)
	 {
		 end = 1;
	 }
	 
	 else if (tend == 2)
	 {
		 end = 2;
	 }
	 
	 else if (tend == 3)
	 {
		 end = 3;
	 }
	 
	 else if (tend == 4)
	 {
		 end = 4;
	 }
 }
 
//Activating the button function
public void act_buttons()
	{
		i++;
		if(i==1) {
		TownStart.setEnabled(true);
		TownEnd.setEnabled(true);
		txtTime.setEditable(true);
		txtRoute.setEditable(true);
		btnClear.setEnabled(true);
		btnTravel.setEnabled(true);
		btnStart.setText("Off");
		i=-1;
		}
		else deact_buttons();
	}

//Deactivating the button function
public void deact_buttons()
	{
		TownStart.setEnabled(false);
		TownEnd.setEnabled(false);
		txtTime.setEditable(false);
		txtRoute.setEditable(false);
		btnClear.setEnabled(false);
		btnTravel.setEnabled(false);
		btnStart.setText("Start");
		clear();
	}
 
// Clear Function
 private void clear()
 	{
	    TownStart.setSelectedIndex(0);
	    TownEnd.setSelectedIndex(0);
	    txtTime.setText("");
	    txtRoute.setText("");
	    Orderedpath = "";
	    select = -1;
	    end = -1;
 	}
 
public void dijkstra (int [][] graph, int selected, int end) 
 {
	 int size = graph.length;
	 //will hold the saved distance to each nodes.
	 int []	saveddistance = new int [size];
	 
	 //will determine if the vertex is visited or not
	 boolean [] visitedV = new boolean [size];
	 
	 //All vertex distances set to infinity and not visited
	 for (int i = 0; i<graph.length; i++) 
	 {
		 visitedV[i] = false;
		 saveddistance[i] = Integer.MAX_VALUE;
	 }
	 
	 //Saved source distance
	 saveddistance[selected] = 0;
	 
	 //Path storage
	 int [] paths = new int [size];
	 
	 //initialize the start town with -1 since it has no connection
	 paths[selected] = -1;
	 
	 // Find shortest path for all vertices
	 for(int i = 0; i < size; i++)
	 {
		 //Updating the node distance from the selected node
		 int n = min_distance(saveddistance, visitedV);
		 
		 //Changing the selected vertex to not visited to visited
		 visitedV[n] = true;
		 
		 //Updating for the least distance for the other elements
		 for(int v = 0; v < size; v++)
		 {
			 //Choosing if the selected vertex's distance is lower than the current saveddistance
			 if (graph[n][v] > 0 && (saveddistance[n] + graph[n][v]) < saveddistance[v]) 
			 { 
				 paths[v] = n;
				 saveddistance[v] = saveddistance[n] + graph[n][v];	 
			 }
		 } 
	  }
	 // Calling printpath function in order to get the path
	 printpath(paths, end);
	 
	 //Saving the district location number from a string path
	 int pathnumber = Integer.parseInt(Orderedpath);
	 
	 //Varible that save the number of the district from the Ordered path string
	 int savednumber [] = new int [Orderedpath.length()];
	 int p = 0;
	 while (pathnumber > 0 ) 
	 {
		savednumber[p] = pathnumber % 10;
		pathnumber = pathnumber/10;
		p++;
	 }
	 
	 //Variable that save the District name
	 String answer = "";
	 
	 //Function that saving the District name
	 int count = (savednumber.length-1);
	 while(count >= 0) 
	 {
		 int num = savednumber[count];
		 answer = answer + listofdistrict[num+1];
		 if (count > 0) 
		 {
			 answer = answer + " -> ";
		 }
		 count--;
	 }
	 
	//Printing the Answer
	txtTime.setText("From " + listofdistrict[selected+1] + " to " + listofdistrict[end+1] + " is " +saveddistance[end]+ " hour/s");
	txtRoute.setText(listofdistrict[selected+1] + " -> " + answer);
	}
 
 //Getting the path
public void printpath (int [] paths, int end) 
  {
	  if(paths[end] == -1)
	  {
		  return;
	  }
	  printpath(paths, paths[end]);
	  Orderedpath = Orderedpath + end;
  }
 
//Function to get the next shortest distance near the current vertex
public static int min_distance(int[] saveddistance, boolean [] visitedV)
  {
	  //Initializing the values of minvertex and min_distance
	  int minvertex = -1, min_distance = Integer.MAX_VALUE;
	  
	  //Getting the vertex that have least minimum distance and not yet visited
	  for(int i = 0; i<saveddistance.length; i++)
	  {
		  if(visitedV[i] == false && saveddistance[i] < min_distance)
		  {
			  min_distance = saveddistance[i];
			  minvertex = i;
		  }
	  }
	  return minvertex;
  }

public static void main(String[] args) 
  { //Opening and Closing of program
    Dijkstra function = new Dijkstra("Route Finder");
    function.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
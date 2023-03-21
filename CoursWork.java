import java.util.*;
class CoursWork{
	public static void topic(int option){
		System.out.println("-------------------------------------------------------------------------------------------------");
		switch(option){
			case 1:System.out.println("|					  Add New Student	  				 |");break;
			case 2:System.out.println("|					Add New Student With Marks				|");break;
			case 3:System.out.println("|					Add Marks	  					|");break;
			case 4:System.out.println("|					Update Student Details					|");break;
			case 5:System.out.println("|						Update Marks					|");break;
			case 6:System.out.println("|						Delete Student					|");break;
			case 7:System.out.println("|					Print Student Details					|");break;
			case 8:System.out.println("|					Print Student Ranks					|");break;
			case 9:System.out.println("|				Best in Programming Fundamentals				|");break;
			case 10:System.out.println("|				Best in Database Management System				|");break;
		}
		System.out.println("-------------------------------------------------------------------------------------------------");
	}
	public final static void clearConsole(){
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
		}
	}
	public static boolean dublicate(String[][] ar,String id){
			String x=id;
				for(int i=0;i<ar.length;i++){
				if(x.equals(ar[i][0])){
					return true;
				}else{
					
				}
			}
			return false;
		}
	public static int addNewStudent(String[][] ar,int i){
		Scanner input=new Scanner(System.in);	
		boolean b=true;	
		while(b){
				System.out.println();
				System.out.print("Enter student ID   : ");
				String id=input.next(); 
				boolean x=dublicate(ar,id);
				while(x){
						System.out.println("The Student ID already exists\n");
						System.out.print("Enter student ID   : ");
						id=input.next();
						x=dublicate(ar,id);
				}
				
				System.out.print("Enter student name :");
				String name=input.next(); 
				ar[i][0]=id;
				ar[i][1]=name;
				i++;
				System.out.println();
				System.out.print("Student has been added successfully. Do you want to add a new student (y/n): ");
				char yesorno=input.next().charAt(0);
				if(yesorno=='y'){
					b=true;
					clearConsole();
					topic(1);
				}else if(yesorno=='n'){
					b=false;
				}
			}
		return i;	
    }
	public static int addNewStudentWithMarks(String[][] ar,int[][] marks,int i){
		Scanner input=new Scanner(System.in);
		boolean b=true;
		while(b){
			
				System.out.print("Enter student ID   :");
				String id=input.next(); 
				boolean x=dublicate(ar,id);	
					while(x){
						System.out.println("The Student ID already exists\n");
						System.out.print("Enter student ID   :");
						id=input.next();
						x=dublicate(ar,id);
					}
				
				System.out.print("Enter student name :");
				String name=input.next(); 
				ar[i][0]=id;
				ar[i][1]=name;
				System.out.println();
		System.out.print("Programming Fundamentals marks    :");
		 marks[i][0]=input.nextInt();
		while(marks[i][0]<0 || marks[i][0]>100){
			System.out.print("Invalid marks. please enter correct marks.\n");
			System.out.println();
			System.out.print("Programming Fundamentals marks    :");
			marks[i][0]=input.nextInt();
		}
		
		System.out.print("Databases Management System marks :");
		 marks[i][1]=input.nextInt();
		while(marks[i][1]<0 || marks[i][1]>100){
			System.out.print("Invalid marks. please enter correct marks.\n");
			System.out.println();
			System.out.print("Databases Management System marks :");
			marks[i][1]=input.nextInt();
		}
		i++;
		System.out.println();
		System.out.print("Student has been added successfully. Do you want to add a new student (y/n): ");
		char yesorno=input.next().charAt(0);
		if(yesorno=='y'){
			b=true;
			clearConsole();
			topic(2);
		}else if(yesorno=='n'){
			b=false;
			}		
		}
	return i;
	}
	public static void addMarks(String[][] ar,int[][] marks){
			Scanner input=new Scanner(System.in);
			boolean b=true;
			int index=0;
			while(b){
				System.out.print("Enter student ID : ");
				String id=input.next();
				boolean x=dublicate(ar,id);
				if(x){
					for (int j = 0; j < ar.length; j++){
					while(id.equals(ar[j][0])){
						index=j;break;
					}
				}
				
				if(marks[index][0]>0 && marks[index][1]>0){
					 
					System.out.println("Student name     : "+ar[index][1]);
						System.out.println("This student's marks have be already added.\nIf you want to update the marks, please use [4] Update Marks option.");
						System.out.println();
						System.out.print("Do you add marks for another student? (y/n) ");
						char yesorno = input.next().charAt(0);
						if(yesorno=='y'){
							b=true;
							clearConsole();
							topic(3);
						}else if(yesorno=='n'){
							//clearConsole();
							b=false;
						}
				}else if(marks[index][0]==0 && marks[index][1]==0){
					
					System.out.println("student name     : "+ar[index][1]);
					System.out.println();
					System.out.print("Programming Fundamentals marks    : ");
					marks[index][0]=input.nextInt();
					while(marks[index][0]<0	|| marks[index][0]>100){
						System.out.println("Invalid marks. please enter correct marks.\n");
						System.out.print("Programming Fundamentals marks    : ");
						marks[index][0]=input.nextInt();
						}
						System.out.print("Databases Management System marks : ");
						marks[index][1]=input.nextInt();
						while(marks[index][1]<0 || marks[index][1]>100){
							System.out.println("Invalid marks. please enter correct marks.\n");
							System.out.print("Databases Management System marks : ");
							marks[index][1]=input.nextInt();
						}
						System.out.print("Do you add marks for another student? (y/n) ");
						char yesorno = input.next().charAt(0);
						if(yesorno=='y'){
							b=true;
							clearConsole();
							topic(3);
						}else if(yesorno=='n'){
							b=false;
						}			
					}	
			}else{
				System.out.print("invalid student ID. Do youu want to search again? (y/n) ");
				char yesorno=input.next().charAt(0);
				if(yesorno=='y'){
					b=true;
				}else if(yesorno=='n'){
					b=false;
							
				}
			}
		}
	}	
	public static void updateStudentDetails(String[][] ar){
			Scanner input=new Scanner(System.in);
			boolean b=true;
			int index=0;
			while(b){
			System.out.print("Enter student ID : ");
			String id=input.next();
			boolean x=dublicate(ar,id);
			for(int j = 0; j < ar.length; j++){
				while(id.equals(ar[j][0])){
					index=j;break;
				}
			}
			if(x){
			  	 
				System.out.println("student name     : "+ar[index][1]);
				System.out.println();
				System.out.print("Enter the new student name: ");
				ar[index][1]=input.next();	
				System.out.println();	

				System.out.print("Student details has been updated successfully.\nDo you want to update another student details? (y/n) ");
				char yesorno=input.next().charAt(0);
				if(yesorno=='y'){
					b=true;
					clearConsole();
					topic(4);
				}else if(yesorno=='n'){
					b=false;
				}	
			}else{
				System.out.print("Invalid student ID. Do you want to search again? (y/n) ");
					char yesorno=input.next().charAt(0);
					if(yesorno=='y'){
						b=true;
					}else if(yesorno=='n'){
						b=false;
					}
				}
			}
		}
	public static void updateMarks(String[][] ar, int[][] marks){
			Scanner input=new Scanner(System.in);
			boolean b=true;
			int index=0;
			while(b){
				System.out.print("Enter student ID : ");		
				String id=input.next();
				boolean x=dublicate(ar,id);
				for (int j = 0; j < ar.length; j++){
					while(id.equals(ar[j][0])){
						index=j;break;
					}
				}
					if(x){
						if(marks[index][0]==0 && marks[index][1]==0){	
								System.out.println("Student name     : "+ar[index][1]);
								System.out.println();
								System.out.print("This student's marks yet to be added.\nDo you want to update the marks of another student? (y/n) ");
								char yesorno=input.next().charAt(0);
								if(yesorno=='y'){
									b=true;
								}else{
									b=false;
								}
						}else{
							
							System.out.println("Student name     : "+ar[index][1]);
							System.out.println();
							System.out.println("Programming Fundamentals Marks   : "+marks[index][0]);
							System.out.println("Database Management System Marks : "+marks[index][1]);
							System.out.println();
							System.out.println();
							System.out.print("Enter new Programming Fundamentals Marks   : ");
							marks[index][0]=input.nextInt();
							while(marks[index][0]<0 || marks[index][0]>100){
								System.out.println("Invalid marks. please enter correct marks\n");
								System.out.print("Enter new Programming Fundamentals Marks   : ");
								marks[index][0]=input.nextInt();
							}
							
							System.out.print("Enter new Database Management System Marks : ");
							marks[index][1]=input.nextInt();
							while(marks[index][1]<0 || marks[index][1]>100){
								System.out.println("Invalid marks. please enter correct marks\n");
								System.out.print("Enter new Programming Fundamentals Marks 	 : ");
								marks[index][1]=input.nextInt();
							}
							System.out.print("Marks has been update successfully.\nDo you want to update marks for another student? (y/n) ");
							char yesorno=input.next().charAt(0);
							if(yesorno=='y'){
								b=true;
								clearConsole();
								topic(5);
							}else if(yesorno=='n'){
								b=false;
							}
						}
					}else{
						System.out.print("Invalid student ID. Do you want to search again? (y/n) ");
						char yesorno=input.next().charAt(0);
						if(yesorno=='y'){
							b=true;
							clearConsole();
						}else if(yesorno=='n'){
							b=false;
						}
					}
				}
			}
	public static void deleteStudent(String[][] ar, int[][] marks){
			Scanner input=new Scanner(System.in);		
			boolean b=true;
			while(b){
				System.out.print("Enter student ID : ");
				String id=input.next();
				boolean x=dublicate(ar,id);
				int index=0;
				if(x){
					for(int j = 0; j < ar.length; j++){
						if(id.equals(ar[j][0])){								
							index=j;
						}
					}
					ar[index][0]=null;
					ar[index][1]=null;
					marks[index][0]=0;
					marks[index][1]=0;
					System.out.print("Student has been Deleted successfully.\nDo you want to deleted another studeny? (y/n) ");
					char yesorno=input.next().charAt(0);
					if(yesorno=='y'){
						b=true;
						clearConsole();
						topic(6);
					}else if(yesorno=='n'){
						b=false;
					}
				}else{
					System.out.print("Invalid Student ID. Do you want to search again? (y/n) ");
					char yesorno=input.next().charAt(0);
					if(yesorno=='y'){
						b=true;
					}else if(yesorno=='n'){
						b=false; 
					}
				}
			}
		}
	public static void printStudentDetails(double[] avg,int[] tot,String[][] ar, int[][] marks){
			Scanner input=new Scanner(System.in);
			int index=0;
			boolean b=true;
			while(b){
			System.out.print("Enter Student ID : ");
			String id=input.next();
			boolean x=dublicate(ar,id);
			if(x){
				for(int j=0;j<ar.length;j++){
					if(id.equals(ar[j][0])){
						index=j;
					}
				}
				System.out.println("Student name     : "+ar[index][1]);
				if(marks[index][0]==0 && marks[index][1]==0){
						System.out.println();
						System.out.print("Marks yet to be added.\n\nDo you want to search another student details? (y/n) ");
						char yesorno=input.next().charAt(0);
						if(yesorno=='y'){
							b=true;
						}else if(yesorno=='n'){
							b=false;
						}
					}else{
						int y=0;				
						for (int j = 0; j <tot.length ; j++){
							tot[j]=marks[j][0]+marks[j][1];
							avg[j]=tot[j]/2.0;
						}
						y=tot[index];
											
						System.out.println("+----------------------------------+---------------------------+");
						System.out.println("| Programming Fundamentals Marks   |\t\t\t    "+marks[index][0]+" |");
						System.out.println("| Database Management System Marks |\t\t\t    "+marks[index][1]+" |");
						System.out.println("| Total Marks  \t\t\t   |\t\t\t   "+tot[index]+" |");
						System.out.println("| avg. Marks  \t\t\t   |\t\t\t  "+avg[index]+" |");
						for(int i=0;i<ar.length;i++ ){
							for(int j = tot.length-1; j >0; j--){
								if(tot[j-1]<tot[j]){
									int temptot=tot[j-1];
									tot[j-1]=tot[j];
									tot[j]=temptot;
									
									double tempavg=avg[j-1];
									avg[j-1]=avg[j];
									avg[j]=tempavg;
									
									String tempid=ar[j-1][0];
									ar[j-1][0]=ar[j][0];
									ar[j][0]=tempid;
									
									String tempname=ar[j-1][1];
									ar[j-1][1]=ar[j][1];
									ar[j][1]=tempname;
									
									int temppfm=marks[j-1][0];
									marks[j-1][0]=marks[j][0];
									marks[j][0]=temppfm;
									
									int tempdbms=marks[j-1][1];
									marks[j-1][1]=marks[j][1];
									marks[j][1]=tempdbms;
									
									
									
									
								}
							}
						}
						int rank=0;
						for(int i = 0; i < tot.length; i++){
							if(y==tot[i]){
								rank=i;break;
							}
						}
						if(rank==0){
							System.out.println("| Rank  \t\t\t   |\t\t       "+(rank+1)+"(First)"+"|");
							System.out.println("+----------------------------------+---------------------------+");	
						}else if(rank==1){
							System.out.println("| Rank  \t\t\t   |\t\t      "+(rank+1)+"(Second)"+"|");
							System.out.println("+----------------------------------+---------------------------+");	
						}else if(rank==2){
							System.out.println("| Rank  \t\t\t   |\t\t       "+(rank+1)+"(Third)"+"|");
							System.out.println("+----------------------------------+---------------------------+");	
						}else if(rank==99){
							System.out.println("| Rank  \t\t\t   |\t\t        "+(rank+1)+"(Last)"+"|");
							System.out.println("+----------------------------------+---------------------------+");	
						}else{
						
						System.out.println("| Rank  \t\t\t   |\t\t\t     "+(rank+1)+" |");
						System.out.println("+----------------------------------+---------------------------+");						
						System.out.println();
					}
						System.out.print("Do you want to search another student details? (y/n) ");
						char yesorno=input.next().charAt(0);
						if(yesorno=='y'){
							b=true;
							clearConsole();
							topic(7);
						}else if(yesorno=='n'){
							b=false;
						
					}
				}
				
			}else{
				System.out.print("Invalid Student ID. Do you want to search again? (y/n) ");
					char yesorno=input.next().charAt(0);
					if(yesorno=='y'){
						b=true;
					}else if(yesorno=='n'){
						b=false; 
					}
				}
			}
		}
	public static void printStudentRanks(double[] avg,int[] tot,String[][] ar, int[][] marks){
			Scanner input=new Scanner(System.in);
			boolean b=true;
			while(b){
				for (int j = 0; j <tot.length ; j++){
					tot[j]=marks[j][0]+marks[j][1];
					avg[j]=tot[j]/2.0;
				}
				for(int i=0;i<ar.length;i++ ){
							for(int j = tot.length-1; j >0; j--){
								if(tot[j-1]<tot[j]){
									int temptot=tot[j-1];
									tot[j-1]=tot[j];
									tot[j]=temptot;
									
									double tempavg=avg[j-1];
									avg[j-1]=avg[j];
									avg[j]=tempavg;
									
									String tempid=ar[j-1][0];
									ar[j-1][0]=ar[j][0];
									ar[j][0]=tempid;
									
									String tempname=ar[j-1][1];
									ar[j-1][1]=ar[j][1];
									ar[j][1]=tempname;
									
									int temppfm=marks[j-1][0];
									marks[j-1][0]=marks[j][0];
									marks[j][0]=temppfm;
									
									int tempdbms=marks[j-1][1];
									marks[j-1][1]=marks[j][1];
									marks[j][1]=tempdbms;
								}
							}
						}
			int[] r=new int[100];
			for (int i = 0; i < r.length; i++){
				r[i]=i;
			}
			int k=0,j = 1;
			for (int i = 0; i <tot.length ; i++){ 
				for (j=k+1; j <tot.length ; j++){
					if(tot[i]==tot[j]){
						r[j]=i;
						k++;
					}
				}
			}
			
						
			System.out.println("+-------+-----+----------------------------------------------------------+-----------+----------+");
			System.out.println("|Rank   |ID   |Name                                                      |Total Marks|Avg. Marks|");
			System.out.println("+-------+-----+----------------------------------------------------------+-----------+----------+");
			for (int i = 0; i < ar.length; i++){
				if(tot[i]!=0){
				System.out.println("|"+(r[i]+1)+"\t|"+ar[i][0]+" |"+ar[i][1]+"\t\t\t\t\t\t\t |\t "+tot[i]+" |\t    "+avg[i]+"|");
				}
			}
				System.out.println("+-------+-----+----------------------------------------------------------+-----------+----------+");
			System.out.print("Do you want to go back main menu? (y/n) ");
			char yesorno=input.next().charAt(0);
			if(yesorno=='y'){
				b=false;
			}else if(yesorno=='n'){
				b=true;
				clearConsole();
				topic(8);
			}
		}
	}	
	public static void bestInProgramingFundamentals(int[] tot,String[][] ar,int[][] marks){
		Scanner input=new Scanner(System.in);
		boolean b=true;
		while(b){
			for (int j = 0; j <tot.length ; j++){
				tot[j]=marks[j][0]+marks[j][1];
			}
			
			for (int j=0; j<marks.length ;j++){
				for (int i=marks.length-1; 0<i ;i--){
					if(marks[i-1][0]<marks[i][0]){
						int temppfm=marks[i-1][0];
						marks[i-1][0]=marks[i][0];
						marks[i][0]=temppfm;
						
						int tempdbms=marks[i-1][1];
						marks[i-1][1]=marks[i][1];
						marks[i][1]=tempdbms;
						
						String tempid=ar[i-1][0];
						ar[i-1][0]=ar[i][0];
						ar[i][0]=tempid;
						
						String tempname=ar[i-1][1];
						ar[i-1][1]=ar[i][1];
						ar[i][1]=tempname;
						
						int temptot=tot[i-1];
						tot[i-1]=tot[i];
						tot[i]=temptot;
					}				
				}
			}
			System.out.println("+-------+----------------------------------------------------------------+-----------+----------+");
			System.out.println("|ID     |Name                                                            |PF Marks   |DBMS Marks|");
			System.out.println("+-------+----------------------------------------------------------------+-----------+----------+");
			for(int j=0;j<ar.length;j++){
				if(tot[j]!=0){
			System.out.println("|"+ar[j][0]+"   |"+ar[j][1]+"\t\t\t\t\t\t\t\t |"+marks[j][0]+"         |"+marks[j][1]+"        |");
				}			
			}
			System.out.println("+-------+----------------------------------------------------------------+-----------+----------+");
			
		System.out.print("Do you want to go back to main menu? (y/n) ");
		char yesorno=input.next().charAt(0);
			if(yesorno=='y'){
				b=false;
			}else if(yesorno=='n'){
				b=true;
				clearConsole();
				topic(9);
			}
		}
	}
	public static void bestInDatabaseManagementSystem(int[] tot,String[][] ar,int[][] marks){
			Scanner input=new Scanner(System.in);
			boolean b=true;
			while(b){
				for (int j = 0; j <tot.length ; j++){
					tot[j]=marks[j][0]+marks[j][1];
				}
				for (int j=0; j<marks.length ;j++){
					for (int i=marks.length-1; 0<i;i--){
						if(marks[i-1][1]<marks[i][1]){
							int tempdbms=marks[i-1][1];
							marks[i-1][1]=marks[i][1];
							marks[i][1]=tempdbms;
							
							int temppfm=marks[i-1][0];
							marks[i-1][0]=marks[i][0];
							marks[i][0]=temppfm;
							
							String tempid=ar[i-1][0];
							ar[i-1][0]=ar[i][0];
							ar[i][0]=tempid;
							
							String tempname=ar[i-1][1];
							ar[i-1][1]=ar[i][1];
							ar[i][1]=tempname;
							
							int temptot=tot[i-1];
							tot[i-1]=tot[i];
							tot[i]=temptot;
						}				
					}
				}
				System.out.println("+-------+----------------------------------------------------------------+-----------+----------+");
				System.out.println("|ID     |Name                                                            |PF Marks   |DBMS Marks|");
				System.out.println("+-------+----------------------------------------------------------------+-----------+----------+");
				for(int j=0;j<ar.length;j++){
					if(tot[j]!=0){
						System.out.println("|"+ar[j][0]+"   |"+ar[j][1]+"\t\t\t\t\t\t\t\t |"+marks[j][0]+"         |"+marks[j][1]+"        |");
					}			
				}
				System.out.println("+-------+----------------------------------------------------------------+-----------+----------+");
				
			System.out.print("Do you want to go back to main menu? (y/n) ");
			char yesorno=input.next().charAt(0);
			if(yesorno=='y'){
				b=false;
			}else if(yesorno=='n'){
				b=true;
				clearConsole();
				topic(10);
			}
		}
	}			
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		String[][] ar=new String[100][2];
		int[][] marks=new int[100][2];
		int[] tot=new int[100];
		double[] avg=new double[100];
		int i=0;
		while(true){
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println("|				WELCOME TO GDSE MARKS MAGAGEMENT SYSTEM				|");
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println("[1] Add New Student\t\t\t\t[2] Add New Student With Marks\n[3] Add Marks\t\t\t\t\t[4] Update Student Details\n[5] Update Marks\t\t\t\t[6] Delete Student\n[7] Print Student Details\t\t\t[8] Print Student Ranks\n[9] Best in Programming Fundamentals\t\t[10] Best in Database Management System");
			System.out.println();
			System.out.print("Enter an option to contiune > ");
			int option=input.nextInt();
			clearConsole();
			topic(option);
			switch(option){
				case 1:
				i=addNewStudent(ar,i);
				clearConsole();break;
				case 2: 
				i=addNewStudentWithMarks(ar,marks,i);
				clearConsole();break;
				case 3:
				addMarks(ar,marks);
				clearConsole();break;
				case 4:
				updateStudentDetails(ar);
				clearConsole();break;
				case 5:
				updateMarks(ar,marks);
				clearConsole();break;
				case 6:
				deleteStudent(ar,marks);
				clearConsole();break;
				case 7:
				printStudentDetails(avg,tot,ar,marks);
				clearConsole();break;
				case 8:
				printStudentRanks(avg,tot,ar,marks);
				clearConsole();break;
				case 9:
				bestInProgramingFundamentals(tot,ar,marks);
				clearConsole();break;
				case 10:
				bestInDatabaseManagementSystem(tot,ar,marks);
				clearConsole();
			}
		}
	}
}
	
						
						
					

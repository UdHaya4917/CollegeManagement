package collectionlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class College {
    private int collegeId;
    private String collegeName;
    private String location;

    College(int collegeId, String collegeName, String location) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.location = location;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getLocation() {
        return location;
    }

    public String toString() {
        return collegeId + " " + collegeName + " " + location;
    }
}

public class CollegeManagement {

	public static void main(String[] args) {
		List<College> colleges = new ArrayList<College>();
        try (Scanner Scanner = new Scanner(System.in);
				Scanner Scanner1 = new Scanner(System.in)) {
			int choice;
			
			do {
				System.out.println("College Management of Students Details");
				System.out.println("	*--------*------*");
			    System.out.println("	1 Upload Details");
			    System.out.println("	2 Display Details");
			    System.out.println("	3 Search Details");
			    System.out.println("	4 Delete Details");
			    System.out.println("	5 Update Details");
			    System.out.println("	*--------*------*");
			    System.out.print("Enter your choice of Number: ");
			    
			    choice = Scanner.nextInt();

			    switch (choice) {
			        case 1:
			            System.out.print("Enter college ID: ");
			            int collegeId = Scanner.nextInt();
			            Scanner.nextLine(); // Clear buffer
			            System.out.print("Enter college name: ");
			            String collegeName = Scanner1.nextLine();
			            System.out.print("Enter college location: ");
			            String location = Scanner1.nextLine();
			            colleges.add(new College(collegeId, collegeName, location));
			            System.out.println("-------**********--------");
			            System.out.println("Students Details Uploaded successfully");
			            System.out.println("--------**********----------");
			            break;

			        case 2:
			            System.out.println("-------******---------");
			            Iterator<College> iterator = colleges.iterator();
			            while (iterator.hasNext()) {
			                College c = iterator.next();
			                System.out.println(c);
			            }
			            System.out.println("--------*****---------");
			            break;

			        case 3:
			            boolean found = false;
			            System.out.print("Enter college ID: ");
			            collegeId = Scanner.nextInt();
			            iterator = colleges.iterator();
			            while (iterator.hasNext()) {
			                College c = iterator.next();
			                if (c.getCollegeId() == collegeId) {
			                    found = true;
			                    System.out.println("-----********-------");
			                    System.out.println(c);
			                }
			            }
			            if (!found) {
			                System.out.println("-----*******---------");
			                System.out.println("College Details not found");
			            }
			            System.out.println("-------***********----------");
			            break;

			        case 4:
			            found = false;
			            System.out.print("Enter college ID to delete: ");
			            collegeId = Scanner.nextInt();
			            iterator = colleges.iterator();
			            while (iterator.hasNext()) {
			                College c = iterator.next();
			                if (c.getCollegeId() == collegeId) {
			                    iterator.remove();
			                    found = true;
			                }
			            }
			            if (!found) {
			                System.out.println("*-------*******---------*");
			                System.out.println("College Details not found");
			            } else {
			                System.out.println("*--------*****-----------*");
			                System.out.println("College Details Deleted successfully");
			            }
			            System.out.println("------******---------");
			            break;

			        case 5:
			            found = false;
			            System.out.print("Enter college ID to update: ");
			            collegeId = Scanner.nextInt();
			            ListIterator<College> listIterator = colleges.listIterator();
			            while (listIterator.hasNext()) {
			                College c = listIterator.next();
			                if (c.getCollegeId() == collegeId) {
			                    Scanner.nextLine(); // Clear buffer
			                    System.out.print("Enter new college name: ");
			                    collegeName = Scanner1.nextLine();
			                    System.out.print("Enter new college location: ");
			                    location = Scanner1.nextLine();
			                    listIterator.set(new College(collegeId, collegeName, location));
			                    found = true;
			                }
			            }
			            if (!found) {
			                System.out.println("*****--------******");
			                System.out.println("College Details not found");
			            } else {
			                System.out.println("College Details Updated successfully");
			            }
			            System.out.println("---------*******---------");
			            break;
			    }
			} while (choice != 0);
		}

	}

}

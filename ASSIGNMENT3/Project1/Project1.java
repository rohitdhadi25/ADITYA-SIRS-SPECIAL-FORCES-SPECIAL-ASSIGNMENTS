import java.lang.*;
import java.util.*;
class Contact{
	ContactNode head;
	int size=0;
	static class ContactNode{
		String name;
		String phoneNo;
		ContactNode next;
			ContactNode(String name,String phoneNo){
				this.name=name;
				this.phoneNo=phoneNo;
				next=null;
			}
	}
	void addContactAtBegin(String name, String phoneNo){
		ContactNode new_node=new ContactNode(name,phoneNo);
		new_node.next=head;
		head=new_node;
		System.out.println("contanct Added: "+ new_node.name +","+new_node.phoneNo);
		size++;
		return;
		
	}
	void addContactAfter(ContactNode prev,String name,String phoneNo){
		ContactNode new_node=new ContactNode(name,phoneNo);
		new_node.next=prev.next;
		prev.next=new_node;
		size++;
		return ;
	}
	void addContactAtLast(String name,String phoneNo){
		ContactNode new_node=new ContactNode(name,phoneNo);
		if(head==null)
		{
			head =new ContactNode(name,phoneNo);
		}
		new_node.next=null;
		ContactNode p=head;		
		while(p.next!=null){
			p=p.next;
		}
		p.next=new_node;
		size++;
		return;
	}
	
	void addContactAt(int index,String name, String phoneNo){
		ContactNode new_node=new ContactNode(name,phoneNo);
		int count=0;
		ContactNode i= head;
		while(count<index-1){
			i=i.next;
			count++;
		}
		//in this case(insertAt) we need to have a prev to the i pointer
		ContactNode prev=i.next;
		i.next=new_node;
		new_node.next=prev;
		size++;
		// System.out.println("Contact Added At: "+index);
		return ;	
	}
	
	void removeContact(String name){
		ContactNode temp=head;
		ContactNode prev=null;
		if(temp!=null && temp.name.equals(name)){
			head=temp.next;
			size--;
			return;
			
		}
		while(temp!=null && !temp.name.equals(name)){
				prev=temp;
				temp=temp.next;
		}
		prev.next=temp.next;
		size--;
		System.out.print("contact removed!!!! ");
		return ;
		
	}
	
	void removeContactWithPosition(int pos,String name){
		ContactNode p =head;
		if(head==null){
			return;
		}
		if(pos==0){
			head=p.next;
		}
		for(int i=0;p!=null && i<pos-1;i++){
			p=p.next;
		}
		if(p==null || p.next==null){
			return ;
		}
		ContactNode Next=p.next.next;
		p.next=Next;
		
		size--;
		return ;
	}
	
	
	void searchContact(String name){
		ContactNode p=head;
		boolean flag=true;
		if(head==null){
			flag=false;
			System.out.println("zero contact found you need to add one!!!!");
			return;
		}
		
		while(p!=null){
			if(p.name.equals(name))
			{ 
				
				flag=true;
				
			}
			else{
				flag=false;
			}
			p=p.next;
		}
		
		if(flag){
			System.out.println("contact found!!!! ");
		}
		else{
			System.out.println("No contact found!!!!");
		}
		return ;
		
	}
	int totalSize(){
		return size;
	}
	void displayContacts(){
		ContactNode p=head;
		System.out.println("Contact List:");
		while(p.next!=null){
			
			System.out.println(p.name+" , "+p.phoneNo);
			p=p.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		Contact c=new Contact();
		Scanner sc=new Scanner(System.in);
		c.head=new ContactNode("Rohit","123124235");
		
		System.out.println("--------------------------------");
		System.out.println("WELCOM TO CONTACT SYSTEM:       |");
		System.out.println("1 to add Contact                |");
		System.out.println("2 to search Contact             |");
		System.out.println("3 to remove Contact             |");
		System.out.println("4 to display Contacts           |");
		System.out.println("0 to Exit                       |");
		System.out.println("Enter your choice               |");
		System.out.println("--------------------------------");
		int ch;
		while((ch=sc.nextInt())!=0){
			switch(ch){
				case 1: System.out.print("Enter Name: ");
						sc.nextLine();
						String n1=sc.nextLine();
						System.out.println();
						System.out.print("Enter PhoneNo: ");
						String phoneNo=sc.nextLine();
						c.addContactAtBegin(n1,phoneNo);
						
						break;
				case 2: System.out.print("Enter Name to be search: ");
						sc.nextLine();
						String n2=sc.nextLine();
						System.out.println();
						c.searchContact(n2);
					break;
				case 3: System.out.print("Enter Name which needs to be removed: ");
						sc.nextLine();
						String n3=sc.nextLine();
						c.removeContact();
						
					break;
				case 4: c.displayContacts();
					break;	
			}
		}
	}
	
}
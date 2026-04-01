

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class OrgChartImpl implements OrgChart{

	//Employee is your generic 'E'..
	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();
	
	public void addRoot(Employee e) {
		GenericTreeNode<Employee> rootEmployee = new GenericTreeNode<Employee>(e);
		nodes.add(rootEmployee);
	}
	public void addDirectReport(Employee manager, Employee newPerson) {
		
		for (int i = 0; i < nodes.size(); i ++) {
			GenericTreeNode<Employee> currentEmployee = nodes.get(i);

			if (currentEmployee.data.equals(manager)) {
				//create node out of newPerson
				GenericTreeNode<Employee> newE = new GenericTreeNode<Employee>(newPerson);
				currentEmployee.addChild(newE);
				nodes.add(newE);
				break;
			}
		}
	}
	
	public void clear() {
		nodes.clear();
	}

	public void showOrgChartDepthFirst() {
		if (nodes.isEmpty()) {
			return;
		}
		depthFirst(nodes.get(0));
		
	}
	
	public void depthFirst(GenericTreeNode<Employee> node) {
		System.out.print(node.data + ", ");
		for (GenericTreeNode<Employee> child : node.children) {
			depthFirst(child);
		}
	}
	
	public void showOrgChartBreadthFirst() {
		if (this.nodes.isEmpty())
			return;
		
		Queue<GenericTreeNode<Employee>> queue = new LinkedList<>();
		queue.offer(this.nodes.get(0));
		
		while (!queue.isEmpty()) {
			GenericTreeNode<Employee> current = queue.poll();
			System.out.print(current.data + ", ");
			
			for (GenericTreeNode<Employee> child : current.children) {
				queue.offer(child);
			}
		}
		
	}//1111
	@Override
   public void removeEmployee(Employee firedPerson) {
      if (!this.nodes.isEmpty()) {
         GenericTreeNode<Employee> root = (GenericTreeNode)this.nodes.get(0);

         for(GenericTreeNode<Employee> parent : this.nodes) {
            for(GenericTreeNode<Employee> child : parent.children) { 
               if (((Employee)child.data).equals(firedPerson)) { 

                  parent.children.addAll(child.children); 
                  parent.children.remove(child); 
                  this.nodes.remove(child); 
                  return; 
               }
            }
         }
      }
   }
}

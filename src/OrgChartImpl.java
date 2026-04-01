

import java.util.ArrayList;
import java.util.List;

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
		if (nodes.isEmpty())
			return;
		
		
	}
	@Override
	public void removeEmployee(Employee firedPerson) {
		// TODO Auto-generated method stub
		if (nodes.isEmpty())
			return;
		GenericTreeNode<Employee> root = nodes.get(0);
		
	}


}

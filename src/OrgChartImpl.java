

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
		GenericTreeNode<Employee> rootEmployee = nodes.get(0);
		if (nodes == null) {
			return;
		}
		nodes.clear();
	}

	public void showOrgChartDepthFirst() {
		return;
	}
	
	public void showOrgChartBreadthFirst() {
		
	}
	@Override
	public void removeEmployee(Employee firedPerson) {
		// TODO Auto-generated method stub
		
	}


}

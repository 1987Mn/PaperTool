/* (swing1.1beta3) */
package com.lzw.util.table;

import java.util.Enumeration;
import java.util.Vector;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**  GroupableTableHeader
 @version 1.0 10/20/98
 @author Nobuo Tamemasa
 */
class GroupableTableHeader extends JTableHeader {
	//private static final String uiClassID = "GroupableTableHeaderUI";
	protected Vector<ColumnGroup> columnGroups = null;

	public GroupableTableHeader(TableColumnModel model) {
		super(model);
		setUI(new GroupableTableHeaderUI(this));
		setReorderingAllowed(false);
	}

	public void setReorderingAllowed(boolean b) {
		reorderingAllowed = false;
	}

	public void addColumnGroup(ColumnGroup g) {
		if (columnGroups == null) {
			columnGroups = new Vector<ColumnGroup>();
		}
		columnGroups.addElement(g);
	}

	public Enumeration getColumnGroups(TableColumn col) {
		if (columnGroups == null)
			return null;
		Enumeration em = columnGroups.elements();
		while (em.hasMoreElements()) {
			ColumnGroup cGroup = (ColumnGroup) em.nextElement();
			Vector v_ret = (Vector) cGroup.getColumnGroups(col, new Vector());
			if (v_ret != null) {
				return v_ret.elements();
			}
		}
		return null;
	}

	public void setColumnMargin() {
		if (columnGroups == null)
			return;
		int columnMargin = getColumnModel().getColumnMargin();
		Enumeration em = columnGroups.elements();
		while (em.hasMoreElements()) {
			ColumnGroup cGroup = (ColumnGroup) em.nextElement();
			cGroup.setColumnMargin(columnMargin);
		}
	}

}

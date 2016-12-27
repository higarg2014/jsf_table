package com.donriver.mbean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import com.donriver.model.DataTableColumn;
import com.donriver.utils.Utils;


/*
 * @Author : Himanshu Garg
 */

/**
 * The Class DynamicTable.
 */
@ManagedBean(name = "dynamicTable")
@ViewScoped
public class DynamicTable implements Serializable {

	/** The logger. */
	private static  Logger logger = Logger.getLogger(DynamicTable.class.getName());
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The data table columns. */
	private List<DataTableColumn> dataTableColumns;
	
	/** The rows. */
	private List<String> rows;
	
	/** The show columns. */
	private List<DataTableColumn> showColumns;
	
	/** The show rows. */
	private List<String> showRows;
	
	/** The row name. */
	private String rowName;
	
	/** The col name. */
	private String colName;
	
	/** The selected cols. */
	private String[] selectedCols;
	
	/** The selected rows. */
	private String[] selectedRows;
	
	/** The date. */
	private Date date;
	
	/** The view date. */
	private String viewDate;

	
	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init() {
		
		 logger.info("Method-Start-> initailization");
		 
		date=new Date();
		dataTableColumns = new ArrayList<DataTableColumn>();
		showColumns = new ArrayList<DataTableColumn>();
		for(String col :Utils.COLUMNS){
			dataTableColumns.add(new DataTableColumn(col, col));
			showColumns.add(new DataTableColumn(col, col));
		}
		
		rows = new ArrayList<String>();
		showRows = new ArrayList<String>();
		for(String row :Utils.ROWS){
			rows.add(row);
			showRows.add(row);
		}
	
		logger.info("Method-End-> initailization");
	}

	/**
	 * Adds the row.
	 *
	 * @return the string
	 */
	public String addRow() {
		 logger.info("Method-Start-> addRow");
		if(StringUtils.isNotBlank(getRowName())){
		rows.add(getRowName());
		showRows.add(getRowName());
		setRowName("");
		}
		 logger.info("Method-End -> addRow");
		return null;
	}

	/**
	 * Adds the column.
	 *
	 * @return the string
	 */
	public String addColumn() {
		 logger.info("Method-Start-> addColumn");
		if(StringUtils.isNotBlank(getColName())){
		dataTableColumns.add(new DataTableColumn(getColName(), getColName()));
		showColumns.add(new DataTableColumn(getColName(), getColName()));
		setColName("");
		}
		logger.info("Method-End -> addColumn");
		return null;
	}

	/**
	 * Filter data.
	 *
	 * @return the string
	 */
	public String filterData() {
		logger.info("Method-Start-> filterData");
		if (date != null) {
			logger.info("Date base filter"+date);
			SimpleDateFormat format = new SimpleDateFormat("EEEE, dd MMMM yyyy");
		    setViewDate(format.format(date));
		} 
		
		if (selectedCols.length > 0) {
			logger.info("Column base filter"+selectedCols);
			dataTableColumns = new ArrayList<DataTableColumn>();
			for (String col : selectedCols) {
				dataTableColumns.add(new DataTableColumn(col, col));
			}

		}
		
		if (selectedRows.length > 0) {
			logger.info("Row base filter"+selectedRows);
			rows = new ArrayList<String>();
			for (String row : selectedRows) {
				rows.add(row);
			}
		}
		logger.info("Method-End -> filterData");
		return null;
	}
	
	/**
	 * On date select.
	 *
	 * @param event the event
	 */
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
	

	/**
	 * Gets the col content.
	 *
	 * @param str1 the str 1
	 * @param str2 the str 2
	 * @return the col content
	 */
	public String getColContent(String str1, String str2) {
		return str1 + "" + str2;
	}
	

	/**
	 * Gets the row name.
	 *
	 * @return the row name
	 */
	public String getRowName() {
		return rowName;
	}
	
	/**
	 * Gets the col name.
	 *
	 * @return the col name
	 */
	public String getColName() {
		return colName;
	}

	/**
	 * Gets the data table columns.
	 *
	 * @return the data table columns
	 */
	public List<DataTableColumn> getDataTableColumns() {
		return dataTableColumns;
	}
	
	/**
	 * Gets the rows.
	 *
	 * @return the rows
	 */
	public List<String> getRows() {
		return rows;
	}

	/**
	 * Gets the show columns.
	 *
	 * @return the show columns
	 */
	public List<DataTableColumn> getShowColumns() {
		return showColumns;
	}

	/**
	 * Gets the show rows.
	 *
	 * @return the show rows
	 */
	public List<String> getShowRows() {
		return showRows;
	}

	/**
	 * Gets the selected cols.
	 *
	 * @return the selected cols
	 */
	public String[] getSelectedCols() {
		return selectedCols;
	}


	/**
	 * Gets the selected rows.
	 *
	 * @return the selected rows
	 */
	public String[] getSelectedRows() {
		return selectedRows;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the data table columns.
	 *
	 * @param dataTableColumns the new data table columns
	 */
	public void setDataTableColumns(List<DataTableColumn> dataTableColumns) {
		this.dataTableColumns = dataTableColumns;
	}

	/**
	 * Sets the rows.
	 *
	 * @param rows the new rows
	 */
	public void setRows(List<String> rows) {
		this.rows = rows;
	}

	/**
	 * Sets the show columns.
	 *
	 * @param showColumns the new show columns
	 */
	public void setShowColumns(List<DataTableColumn> showColumns) {
		this.showColumns = showColumns;
	}

	/**
	 * Sets the show rows.
	 *
	 * @param showRows the new show rows
	 */
	public void setShowRows(List<String> showRows) {
		this.showRows = showRows;
	}

	/**
	 * Sets the row name.
	 *
	 * @param rowName the new row name
	 */
	public void setRowName(String rowName) {
		this.rowName = rowName;
	}

	/**
	 * Sets the col name.
	 *
	 * @param colName the new col name
	 */
	public void setColName(String colName) {
		this.colName = colName;
	}

	/**
	 * Sets the selected cols.
	 *
	 * @param selectedCols the new selected cols
	 */
	public void setSelectedCols(String[] selectedCols) {
		this.selectedCols = selectedCols;
	}

	/**
	 * Sets the selected rows.
	 *
	 * @param selectedRows the new selected rows
	 */
	public void setSelectedRows(String[] selectedRows) {
		this.selectedRows = selectedRows;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the view date.
	 *
	 * @return the view date
	 */
	public String getViewDate() {
		if (date != null) {
			SimpleDateFormat format = new SimpleDateFormat("EEEE, dd MMMM yyyy");
		    return format.format(date);
		} 
		return viewDate;
	}

	/**
	 * Sets the view date.
	 *
	 * @param viewDate the new view date
	 */
	public void setViewDate(String viewDate) {
		
			this.viewDate = viewDate;
		
	}

	


}

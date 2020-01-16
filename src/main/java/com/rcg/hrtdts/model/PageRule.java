package com.rcg.hrtdts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PageRule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pageId;

	private String pageKey;

	private long roleId;

	private long parentId;
	
	private long levelId;
	
	private String path;
	
	private String icon;
	
	private String label;
	
	private int sort;
	
	private boolean menu;

	public long getPageId() {
		return pageId;
	}

	public void setPageId(long pageId) {
		this.pageId = pageId;
	}

	public String getPageKey() {
		return pageKey;
	}

	public void setPageKey(String pageKey) {
		this.pageKey = pageKey;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}



	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getLevelId() {
		return levelId;
	}

	public void setLevelId(long levelId) {
		this.levelId = levelId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public boolean isMenu() {
		return menu;
	}

	public void setMenu(boolean menu) {
		this.menu = menu;
	}
	
	

}

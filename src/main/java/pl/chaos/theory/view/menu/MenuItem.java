package pl.chaos.theory.view.menu;

public class MenuItem {
	private final String description;
	private final String iconName;
	private final String pageUrl;

	public MenuItem(String description, String iconName, String pageUrl) {
		this.description = description;
		this.iconName = iconName;
		this.pageUrl = pageUrl;
	}

	public String getDescription() {
		return description;
	}

	public String getIconName() {
		return iconName;
	}

	public String getPageUrl() {
		return pageUrl;
	}
}

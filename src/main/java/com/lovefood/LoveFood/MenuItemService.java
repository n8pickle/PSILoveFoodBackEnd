package com.lovefood.LoveFood;

import java.util.List;

public class MenuItemService implements IMenuItemService{
    private IMenuItemRepository _menuItemRepository;

    public MenuItemService(IMenuItemRepository _menuItemRepository)
    {
        this._menuItemRepository = _menuItemRepository;
    }
    public List<MenuItem> getMenuItems() {
        return _menuItemRepository.getMenuItems();
    }
}

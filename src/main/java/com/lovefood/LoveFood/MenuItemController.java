package com.lovefood.LoveFood;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuItemController {
    private IMenuItemService _menuItemService;
    public MenuItemController(IMenuItemService _menuItemService)
    {
        this._menuItemService = _menuItemService;
    }

    @RequestMapping("/menu")
    public List<MenuItem> getMenuItems() {
        return _menuItemService.getMenuItems();
    }
}

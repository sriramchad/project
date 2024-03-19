package com.hexaware.fooddelivery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import com.hexaware.fooddelivery.dto.MenuDTO;
import com.hexaware.fooddelivery.entity.Menu;
import com.hexaware.fooddelivery.exception.MenuNotFoundException;
import com.hexaware.fooddelivery.repository.MenuRepository;

@ExtendWith(MockitoExtension.class)
public class MenuServiceImpTest {

    @Mock
    private MenuRepository repo;

    @InjectMocks
    private MenuSeviceImp service;

    @Test
    void testAddMenu() {
        
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setMenuItemId(1);
        menuDTO.setRestaurantId(201);
        menuDTO.setItemName("Burger");
        menuDTO.setDescription("Delicious Burger");
        menuDTO.setPrice(150.0);

        Menu savedMenu = new Menu();
        savedMenu.setMenuItemId(1);
//        savedMenu.setRestaurantId(201);
        savedMenu.setItemName("Burger");
        savedMenu.setDescription("Delicious Burger");
        savedMenu.setPrice(150.0);

        when(repo.save(Mockito.any(Menu.class))).thenReturn(savedMenu);

     
        Menu result = service.addMenu(menuDTO);

        assertEquals(savedMenu, result);
        verify(repo).save(Mockito.any(Menu.class));
    }

    

    @Test
    void testGetById_NotFound() {
       
        int menuItemId = 1;

        when(repo.findById(menuItemId)).thenReturn(Optional.empty());

      
        assertThrows(MenuNotFoundException.class, () -> service.getById(menuItemId));
    }

    @Test
    void testGetAllMenu() {
      
        List<Menu> menuList = new ArrayList<>();
//        menuList.add(new Menu(1, 201, "Burger", "Delicious Burger", 150.0));
//        menuList.add(new Menu(2, 201, "Pizza", "Tasty Pizza", 200.0));

        when(repo.findAll()).thenReturn(menuList);

      
        List<Menu> result = service.getAllMenu();

     
        assertEquals(menuList, result);
    }

    

    @Test
    void testDeleteById() {
        
        int menuItemId = 1;

        Menu existingMenu = new Menu();
        existingMenu.setMenuItemId(menuItemId);
//        existingMenu.setRestaurantId(201);
        existingMenu.setItemName("Burger");
        existingMenu.setDescription("Delicious Burger");
        existingMenu.setPrice(150.0);

        when(repo.findById(menuItemId)).thenReturn(Optional.of(existingMenu));

       
        service.deleteById(menuItemId);

       
        verify(repo).findById(menuItemId);
        verify(repo).deleteById(menuItemId);
    }

  

    

    @Test
    void testGetByItemName_NotFound() {
       
        String itemName = "NonExistentItem";

        when(repo.findByItemName(itemName)).thenReturn(null);

      
        assertThrows(MenuNotFoundException.class, () -> service.getByItemName(itemName));
    }

    private MenuDTO menuDTOFromEntity(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setMenuItemId(menu.getMenuItemId());
//        menuDTO.setRestaurantId(menu.getRestaurantId());
        menuDTO.setItemName(menu.getItemName());
        menuDTO.setDescription(menu.getDescription());
        menuDTO.setPrice(menu.getPrice());
        return menuDTO;
    }
}

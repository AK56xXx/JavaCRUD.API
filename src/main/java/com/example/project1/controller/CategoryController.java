package com.example.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project1.entities.Category;
import com.example.project1.service.IServiceCategory;

@Controller
@RequestMapping("/category")
public class CategoryController {

IServiceCategory iServiceCategory;

public CategoryController(IServiceCategory iServiceCategory) {
    this.iServiceCategory = iServiceCategory;
}


 @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("categories", iServiceCategory.findAllCategories());
        return "showCategories"; //calling html template
    }

    @GetMapping("/new")
    public String affichenewform(Model model){
        // send the attribute and its related value with the url
        return "addCategory";
    }

    @PostMapping("/add")
    public String add(Category category){
        iServiceCategory.createCategory(category);
        return "redirect:/category/all"; //redirect to the showCategories page using its url
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        // send the attribute and its related value with the url (to the edit form)
        model.addAttribute("category", iServiceCategory.findCategoryById(id));
        return "editCategory";
    }

    @PostMapping("/update")
    public String update(Category category){
        // submit update from the edit form
        iServiceCategory.updateCategory(category);
        return "redirect:/category/all";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        iServiceCategory.deleteCategory(iServiceCategory.findCategoryById(id));;
        return "redirect:/category/all";
    }


    
}

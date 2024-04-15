package controller;

import dao.IProductDAO;
import dao.IProductDAOImpl;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IProductDAO iProductDAO;

    public void init() {
        iProductDAO = new IProductDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
            case "delete":
                deleteProduct(request,response);
                break;
            case "edit":
                ShowEditForm(request,response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void ShowEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = iProductDAO.selectById(id);
        request.setAttribute("product",existingProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");

        try{
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("productName");
        List<Product> productList = new ArrayList<>();
        productList = iProductDAO.findProduct(searchName);
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        try{
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = iProductDAO.selectAllProduct();
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        try{
            dispatcher.forward(request,response);
        }
        catch (ServletException se){
            se.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        };
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertProduct(request, response);
                break;
            case "search":
                search(request,response);
                break;
            case "edit":
                edit(request,response);
                break;
    }
}

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product product = new Product(id,name,price,quantity,color,description,categoryId);
        iProductDAO.updateProduct(product);
        try {
            response.sendRedirect("/ProductServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iProductDAO.delete(id);
        try {
            response.sendRedirect("/ProductServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        Integer categoryId = Integer.valueOf(request.getParameter("categoryId"));
        Product product = new Product(name,price,quantity,color,description,categoryId);
        try {
            iProductDAO.insertProduct(product);
            response.sendRedirect("/ProductServlet");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    }

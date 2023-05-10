package dao;

import model.Consumer;
import model.Factory;
import model.Product;
import model.Variety;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static controller.Main.emf;

public class DaoImpl implements Dao {
    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    public void insertData() throws IOException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create factory object
        System.out.println("Enter Factory Name");
        String factName = bf.readLine();
        System.out.println("Enter Estb. date (yyyy-mm-dd)");
        Date EstbDate = Date.valueOf(bf.readLine());
        Factory factory = new Factory();
        factory.setFname(factName);
        factory.setEstbDate(EstbDate);

        // Create product object
        System.out.println("Enter your Product");
        String prodName = bf.readLine();
        System.out.println("Enter Manufacture date (yyyy-mm-dd)");
        Date manufacture = Date.valueOf(bf.readLine());
        System.out.println("Enter Expiry date (yyyy-mm-dd)");
        Date expiry = Date.valueOf(bf.readLine());
        Product product = new Product();
        product.setPname(prodName);
        product.setManufacture(manufacture);
        product.setExpire(expiry);

        // Associate product with factory
        factory.setProduct(product);
        product.setFactory(factory);

        // Create and associate consumer objects
        System.out.println("How many customers do you want to add?");
        int customerCount = Integer.parseInt(bf.readLine());
        List<Consumer> consumerList = new ArrayList<Consumer>();
        for (int i = 0; i < customerCount; i++) {
            Consumer consumer = new Consumer();
            System.out.println("Enter customer Name");
            String CustName = bf.readLine();
            System.out.println("Enter Buy date (yyyy-mm-dd)");
            Date BuyDate = Date.valueOf(bf.readLine());
            consumer.setCname(CustName);
            consumer.setBuyingDate(BuyDate);
            consumer.setProduct(product);
            consumerList.add(consumer);
            em.persist(consumer);
        }

        // Persist objects
        em.persist(product);
        em.persist(factory);
        em.getTransaction().commit();
        System.out.println("Data Added");
        em.close();
    }


    public void insertVariety() throws IOException {
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Enter Variety name");
        String varName= bf.readLine();

        Variety variety=new Variety();
        variety.setVname(varName);

        em.persist(variety);
        em.getTransaction().commit();
        em.close();
    }

    public void updateData() throws IOException {
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Enter product Id :");
        int pid= Integer.parseInt(bf.readLine());

        Product product=em.find(Product.class,pid);
        if(product==null){
            System.out.println("product not found");
        }
        else{
            System.out.println("Update Expiry Date (yyyy-mm-dd)");
            Date expiry = Date.valueOf(bf.readLine());
            product.setExpire(expiry);
            em.merge(product);
            em.persist(product);
            em.getTransaction().commit();
            em.close();
        }

    }

    public void deleteData() throws IOException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Enter Factory Id :");
        int factoryId = Integer.parseInt(bf.readLine());

        Factory factory = em.find(Factory.class, factoryId);
        if (factory == null) {
            System.out.println("Factory not found");
        } else {
            em.remove(factory);
            em.getTransaction().commit(); // commit the transaction before closing the EntityManager
            System.out.println("Data deleted !!");
        }
        em.close();
    }




    public void mapping() throws IOException {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("enter product id : ");
        int pid= Integer.parseInt(bf.readLine());

        Product product= em.find(Product.class,pid);
        List<Variety> varietyList=new ArrayList<Variety>();


        System.out.println("how many varieties  the product has ");
        int vcount= Integer.parseInt(bf.readLine());

        for(int i=0;i<vcount;i++){
            System.out.println("enter variety id :");
            int vid= Integer.parseInt(bf.readLine());

            Variety variety=em.find(Variety.class,vid);
            varietyList.add(variety);
        }

        product.setVariety(varietyList);
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    public void criteria() {
        EntityManager em=emf.createEntityManager();

        CriteriaBuilder cb= em.getCriteriaBuilder();
        CriteriaQuery cq= cb.createQuery(Product.class);
        Root<Product> root=cq.from(Product.class);
        Date date = Date.valueOf("2020-09-09");
        cq.select(root).where(cb.lessThan(root.<Date>get("Expire"), date));

        Query query=em.createQuery(cq);
        List<Product> product= query.getResultList();

        for(Product product1: product){
            System.out.println("name :: "+product1.getPname()+" date :: "+product1.getExpire());
        }
        em.close();
    }


    public void criteria1() {
        EntityManager em=emf.createEntityManager();

      CriteriaBuilder cb= emf.getCriteriaBuilder();
      CriteriaQuery cq=cb.createQuery(Product.class);
      Root<Product> root= cq.from(Product.class);
        Join<Product,Variety> productVarietyJoin= root.join("vname", JoinType.LEFT);

        cq.multiselect(root,cb.count(productVarietyJoin));
        cq.groupBy(root);
        Query query= em.createQuery(cq);
        List<Object[]> list= query.getResultList();{
            for(Object[] obj: list){
                Product p=new Product();
                Long count = (Long) obj[1];
                System.out.println("Product: " + p.getPname() + ", Varieties: " + count);
            }
        }
        em.close();
    }
    public void criteria2() {
        EntityManager em=emf.createEntityManager();

        CriteriaBuilder cb= em.getCriteriaBuilder();
        CriteriaQuery cq= cb.createQuery(Consumer.class);
        Root<Consumer> root=cq.from(Consumer.class);
cq.groupBy(root.get("product_pid"));
        Query query=em.createQuery(cq);
        List<Consumer> consumer= query.getResultList();

        for(Consumer consumer1: consumer){
            System.out.println("id  :: "+ consumer1.getCid()+ "name :: "+consumer1.getCname()+" date :: "+consumer1.getBuyingDate());
        }
        em.close();
    }
}

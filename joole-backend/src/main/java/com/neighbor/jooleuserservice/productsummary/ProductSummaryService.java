package com.neighbor.jooleuserservice.productsummary;

import com.neighbor.jooleuserservice.Contact.Contact;
import com.neighbor.jooleuserservice.productDetails.ProductDetails;
import com.neighbor.jooleuserservice.productDocumentation.ProductDocumentation;
import com.neighbor.jooleuserservice.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductSummaryService  {

    @Autowired
    private ProductSummaryRepository psRepo;

    @Transactional
    public List<ProductSummary> getAllProductSummaries() {
        List<ProductSummary> ps = new ArrayList<>();
        psRepo.findAll().forEach(ps::add);
        return ps;
    }

    @Transactional
    public ProductSummary getByModel(String model){
        //return testUsers.stream().filter(t -> t.getUsername().equals(subjectUsername)).findFirst().get();
        return psRepo.findByModel(model);
    }

    @Transactional
    public ProductSummary getById(Integer id){
        //return testUsers.stream().filter(t -> t.getUsername().equals(subjectUsername)).findFirst().get();
        return psRepo.getOne(id);
    }

    @Transactional
    public void deletePsById(Integer id) {
        psRepo.deleteById(id);
    }

    @Transactional
    public boolean addProduct(ProductSummary ps) {
        return psRepo.save(ps)!= null;
    }

    @PostConstruct
    private void setupDefaultProduct() {

        if (psRepo.count() == 0) {//if nothing in database

            ProductSummary defaultPs = new ProductSummary("Big Ass","Haiku","S3150-SO","Commercial","Indoor","Roof","With Light","2016","5467","1.95","21.14","100","240","35","200","7","35","60","12.3","57","13","HVAC Fans", "https://s3.amazonaws.com/ba-en-us/includes/for-home/haiku-feature.jpg");
            ProductSummary defaultPsTwo = new ProductSummary("Emerson","Luray Eco Series","CF860","Commercial","Outdoor","Roof","With Light","2017","8500","3.5","33","150","300","50","275","10","40","60","20.3","70","17","HVAC Fans", "https://s3.amazonaws.com/ba-en-us/includes/for-home/i6-feature.jpg");
            ProductSummary defaultPsThree = new ProductSummary("Minka","Aviation Series","F853-RW","Commercial","Indoor","Roof","None","2014","6604","2.35","25.92","90","220","65","230","8","36","60","14.5","60","14","HVAC Fans", "https://s3.amazonaws.com/ba-en-us/includes/haiku-l/header__white-hybrid-resin__.jpg");
            ProductSummary defaultPsFour = new ProductSummary("Westinghouse","Industrial Ceiling Fan","78003","Commercial","Indoor","Roof","None","2018","6846","20","60","190","340","65","300","12","48","56","18.2","70","15","HVAC Fans", "https://s3.amazonaws.com/ba-en-us/includes/for-home/isis.jpg");


            ProductDetails onePd=new ProductDetails("Here is my content 1");
            ProductDetails twoPd=new ProductDetails("Here is my content 2");
            ProductDetails threePd=new ProductDetails("Here is my content 3");
            ProductDetails fourPd=new ProductDetails("Here is my content 4");

            ProductDetails fivePd=new ProductDetails("Here is my content 5");
            ProductDetails sixPd=new ProductDetails("Here is my content 6");
            ProductDetails sevenPd=new ProductDetails("Here is my content 7");
            ProductDetails eightPd=new ProductDetails("Here is my content 8");

            ProductDetails ninePd=new ProductDetails("Here is my content 1");
            ProductDetails tenPd=new ProductDetails("Here is my content 2");
            ProductDetails elevenPd=new ProductDetails("Here is my content 3");
            ProductDetails twelvePd=new ProductDetails("Here is my content 4");

            ProductDetails thirtheenPd=new ProductDetails("Here is my content 1");
            ProductDetails fourteenPd=new ProductDetails("Here is my content 4");
            ProductDetails fifteenPd=new ProductDetails("Here is my content 2");
            ProductDetails sixteenPd=new ProductDetails("Here is my content 3");


            onePd.setPs(defaultPs);
            twoPd.setPs(defaultPs);
            threePd.setPs(defaultPs);
            fourPd.setPs(defaultPs);

            fivePd.setPs(defaultPsTwo);
            sixPd.setPs(defaultPsTwo);
            sevenPd.setPs(defaultPsTwo);
            eightPd.setPs(defaultPsTwo);

            ninePd.setPs(defaultPsThree);
            tenPd.setPs(defaultPsThree);
            elevenPd.setPs(defaultPsThree);
            twelvePd.setPs(defaultPsThree);

            thirtheenPd.setPs(defaultPsFour);
            fourteenPd.setPs(defaultPsFour);
            fifteenPd.setPs(defaultPsFour);
            sixteenPd.setPs(defaultPsFour);

            defaultPs.getProductDetails().add(onePd);
            defaultPs.getProductDetails().add(twoPd);
            defaultPs.getProductDetails().add(threePd);
            defaultPs.getProductDetails().add(fourPd);

            defaultPsTwo.getProductDetails().add(fivePd);
            defaultPsTwo.getProductDetails().add(sixPd);
            defaultPsTwo.getProductDetails().add(sevenPd);
            defaultPsTwo.getProductDetails().add(eightPd);

            defaultPsThree.getProductDetails().add(ninePd);
            defaultPsThree.getProductDetails().add(tenPd);
            defaultPsThree.getProductDetails().add(elevenPd);
            defaultPsThree.getProductDetails().add(twelvePd);

            defaultPsFour.getProductDetails().add(thirtheenPd);
            defaultPsFour.getProductDetails().add(fourteenPd);
            defaultPsFour.getProductDetails().add(fifteenPd);
            defaultPsFour.getProductDetails().add(sixteenPd);

            ProductDocumentation onePdoc =new ProductDocumentation("title 1","doc",defaultPs);
            ProductDocumentation twoPdoc =new ProductDocumentation("title 2","rvt",defaultPs);
            ProductDocumentation threePdoc =new ProductDocumentation("title 3","pdf",defaultPs);
            ProductDocumentation fourPdoc =new ProductDocumentation("title 4","dwg",defaultPs);

            ProductDocumentation fivePdoc =new ProductDocumentation("title 1","doc",defaultPsTwo);
            ProductDocumentation sixPdoc =new ProductDocumentation("title 2","rvt",defaultPsTwo);
            ProductDocumentation sevenPdoc =new ProductDocumentation("title 3","pdf",defaultPsTwo);
            ProductDocumentation eightPdoc =new ProductDocumentation("title 4","dwg",defaultPsTwo);

            ProductDocumentation ninePdoc =new ProductDocumentation("title 1","doc",defaultPsThree);
            ProductDocumentation tenPdoc =new ProductDocumentation("title 2","rvt",defaultPsThree);
            ProductDocumentation elevenPdoc =new ProductDocumentation("title 3","pdf",defaultPsThree);
            ProductDocumentation twelvePdoc =new ProductDocumentation("title 4","dwg",defaultPsThree);

            ProductDocumentation thirtheenPdoc =new ProductDocumentation("title 1","doc",defaultPsFour);
            ProductDocumentation fourtheenPdoc =new ProductDocumentation("title 2","rvt",defaultPsFour);
            ProductDocumentation fifteenPdoc =new ProductDocumentation("title 3","pdf",defaultPsFour);
            ProductDocumentation sixteenPdoc =new ProductDocumentation("title 4","dwg",defaultPsFour);

            defaultPs.getProductDocumentation().add(onePdoc);
            defaultPs.getProductDocumentation().add(twoPdoc);
            defaultPs.getProductDocumentation().add(threePdoc);
            defaultPs.getProductDocumentation().add(fourPdoc);

            defaultPsTwo.getProductDocumentation().add(fivePdoc);
            defaultPsTwo.getProductDocumentation().add(sixPdoc);
            defaultPsTwo.getProductDocumentation().add(sevenPdoc);
            defaultPsTwo.getProductDocumentation().add(eightPdoc);

            defaultPsThree.getProductDocumentation().add(ninePdoc);
            defaultPsThree.getProductDocumentation().add(tenPdoc);
            defaultPsThree.getProductDocumentation().add(elevenPdoc);
            defaultPsThree.getProductDocumentation().add(twelvePdoc);

            defaultPsFour.getProductDocumentation().add(thirtheenPdoc);
            defaultPsFour.getProductDocumentation().add(fourtheenPdoc);
            defaultPsFour.getProductDocumentation().add(fifteenPdoc);
            defaultPsFour.getProductDocumentation().add(sixteenPdoc);

            Contact oneC = new Contact("Sales Respresentative","Tom Salesman",null,"(845)-659-9999","people@people.com","peoplearegreat.com",defaultPs);
            Contact twoC = new Contact("Manufacturer",null,"Tech Support","(845)-659-9999","people@people.com","hugefansfam.com",defaultPs);

            Contact threeC = new Contact("Sales Respresentative","Tom Salesman",null,"(845)-659-9999","people@people.com","peoplearegreat.com",defaultPsTwo);
            Contact fourC = new Contact("Manufacturer",null,"Tech Support","(845)-659-9999","people@people.com","hugefansfam.com",defaultPsTwo);

            Contact fiveC = new Contact("Sales Respresentative","Tom Salesman",null,"(845)-659-9999","people@people.com","peoplearegreat.com",defaultPsThree);
            Contact sixC = new Contact("Manufacturer",null,"Tech Support","(845)-659-9999","people@people.com","hugefansfam.com",defaultPsThree);

            Contact sevenC = new Contact("Sales Respresentative","Tom Salesman",null,"(845)-659-9999","people@people.com","peoplearegreat.com",defaultPsFour);
            Contact eightC = new Contact("Manufacturer",null,"Tech Support","(845)-659-9999","people@people.com","hugefansfam.com",defaultPsFour);

            defaultPs.getContacts().add(oneC);
            defaultPs.getContacts().add(twoC);

            defaultPsTwo.getContacts().add(threeC);
            defaultPsTwo.getContacts().add(fourC);

            defaultPsThree.getContacts().add(fiveC);
            defaultPsThree.getContacts().add(sixC);

            defaultPsFour.getContacts().add(sevenC);
            defaultPsFour.getContacts().add(eightC);

            psRepo.save(defaultPs);
            psRepo.save(defaultPsTwo);
            psRepo.save(defaultPsThree);
            psRepo.save(defaultPsFour);
        }
    }
}

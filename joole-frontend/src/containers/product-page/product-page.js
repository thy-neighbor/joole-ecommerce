import React, {Component} from 'react';
import {connect} from 'react-redux';
import {retrieveProducts} from '../../store/actions/product';
import NavBar from '../../components/header/NavBar';
import requiresLogin from '../../hoc/requires-login';
import TechSpecs from './tech-specs';
import ProductCard from './product-card';


class ProductPage extends Component{
    constructor(props){
       super(props);
       this.props.retrieveProducts();
   } 

   handleSearchSubmit = (input) =>{
       console.log("Handle Search Submit ", input );
   }


   render(){
       let products;
       if(this.props.searchFilter && this.props.products){
           const filter=this.props.searchFilter;
            products= this.props.products.filter((product) => {
            let {modelYear,airFlow,powerMax,soundAtMaxSpeed,fanSweepDiameter} = product;
            modelYear = parseInt(modelYear);
            const airflowVal = parseInt(airFlow);
            const maxPowerVal = parseFloat(powerMax);
            const soundVal = parseInt(soundAtMaxSpeed);
            const fanSweepVal = parseInt(fanSweepDiameter); 

            console.log("modelYear ", (modelYear <= filter.modelYear.max) && (modelYear >= filter.modelYear.min));
            console.log("airflowVal ", airflowVal," vs ",filter.airflowVal.max," ", (airflowVal <= filter.airflowVal.max) && (airflowVal >= filter.airflowVal.min));
            console.log("maxPowerVal ", (maxPowerVal <= filter.maxPowerVal.max) && (maxPowerVal >= filter.maxPowerVal.min));
            console.log("sound ", (soundVal <= filter.soundVal.max) && (soundVal >= filter.soundVal.min));
            console.log("fanSweep ", (fanSweepVal <= filter.fanSweepVal.max) && (fanSweepVal >= filter.fanSweepVal.min));
            

            if((modelYear <= filter.modelYear.max) && (modelYear >= filter.modelYear.min)
                && 
                ((airflowVal <= filter.airflowVal.max) && (airflowVal >= filter.airflowVal.min))
                && 
                ((maxPowerVal <= filter.maxPowerVal.max) && (maxPowerVal >= filter.maxPowerVal.min))
                && 
                ((soundVal <= filter.soundVal.max) && (soundVal >= filter.soundVal.min))
                && 
                ((fanSweepVal <= filter.fanSweepVal.max) && (fanSweepVal >= filter.fanSweepVal.min))
            ){return product;}
        });
       }else{
        products=this.props.products?this.props.products:null;
       }
       
       if(this.props.searchValue && products){
           products=products.filter((product)=>{if(product.type===this.props.searchValue){return product;}});
       }
       
       
        const productCards=products?products.map((product, index) => 
        <ProductCard data={product} key={index} /> 
        
        ) : null;
        
       return(
           <section className="login-container">
               <NavBar invisible={false} loggedIn={this.props.currentUser}/>
               <div className="row col-12">
                   <div className="col-2">
                       <TechSpecs/>
                   </div>
                   <div className="col-10">
                       <div className="row">
                           {this.props.products!==null && productCards}
                           {this.props.products===null && "No Search Results Found"}
                       </div>
                   </div>
               </div>
           </section>
       );
   }
}
const mapStateToProps = state => {

   return{
       currentUser: state.auth.currentUser,
       types: state.product.types,
       products: state.product.products,
       searchValue: state.product.searchValue,
       searchFilter: state.product.searchFilter ? state.product.searchFilter : null
   }
};


export default requiresLogin()(connect(mapStateToProps,{retrieveProducts})(ProductPage));
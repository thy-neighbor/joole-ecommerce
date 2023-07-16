import React from 'react';
import {connect} from 'react-redux';
import {setSearchFocus} from '../../store/actions/product'


export const Dropdown = (props) => {
    //props.values should be a list of objects that have the master product types(ex. mechanical)
    //let list=["Mechanical","Electronic","Stone Age", "Ice Age"];
    const list = props.options ? props.options : [{type:"Mechanical", parentType:null}];
    
    let productTypes=list.map((value,key) =>{
        if(value.parentType===null){
            return(<span class="dropdown-item" onClick={()=>{props.setSearchFocus(value.type)}} key={key}>{value.type}</span>);
        }
        return;
    }
        
        
    );

    console.log( productTypes );
        
    return(
        <span class="dropdown dropdown-container">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                {/*list[0].type*/}
                {/*window.location.hash ? window.location.hash.substr(1) : null list[0].type*/}
                {props.searchFocus ? props.searchFocus : "Types" }
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                {productTypes}
            </div>
        </span>
    );
    
};

const mapStateToProps = state =>{
    return{
        searchFocus: state.product.searchFocus
    }
};

export default connect(mapStateToProps,{setSearchFocus})(Dropdown);

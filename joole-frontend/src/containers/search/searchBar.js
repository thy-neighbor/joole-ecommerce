import React from 'react';
import Dropdown from './dropdown';
import {connect} from 'react-redux';

export const SearchBar = (props) => {

    let list = props.types ? props.types : [{type:"Mechanical", parentType:null}];

    if(props.searchFocus && list.length>=1)
    list= list.filter((value)=>{
        console.log(value.parentType ,"vs", props.searchFocus ,value.parentType===props.searchFocus );
        if(value.parentType===props.searchFocus){
            return value;
        }

    });
 
    const recentSearches = list.map((value,index) => {return (<option value={value.type} key={index}/>);});

    return(
        <form onSubmit={(input => props.handleSearchSubmit(input))} autoComplete="off">
            <div className="form-group search-form-group">
                <Dropdown options={props.types}/>
                <input class="search-area" type="search" name="product-search" id="product-search" placeholder="Search..." list="suggestions"  /> 
                <datalist id="suggestions">
                    {recentSearches}
                </datalist>
                <button type="submit" class="btn btn-search"><i class="fas fa-search" aria-hidden="true"></i></button>
            </div>
        </form>

    );

};

const mapStateToProps = state =>{
    return{
        searchFocus: state.product.searchFocus
    }
};

export default connect(mapStateToProps)(SearchBar);
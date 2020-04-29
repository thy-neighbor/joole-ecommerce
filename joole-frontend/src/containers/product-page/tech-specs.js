import React from 'react';
import RangeInput from './RangeInput';
import {connect} from 'react-redux';
import {setSearchFilter, resetSearchFilter} from '../../store/actions/product';

const originalData = {
    modelYear:{min:2007, max:2020},
    airflowVal: { min: 2000, max: 10000 },
    maxPowerVal: { min: 8.00, max: 150 },
    soundVal: { min: 0, max: 100 },
    fanSweepVal: { min: 12, max: 112 }
};
 
class TechSpecs extends React.Component{
    constructor(props){
        super(props);

        this.state = {
            cacheFilter: this.props.searchFilter, //represents current
            reset:false   //represents current 
          };

        this.props.resetSearchFilter();
    }

    changeValue = (cacheFilter) =>{
        //this.props.setSearchFilter(filter);
        this.setState({cacheFilter});
    };

    changeFilter = (cacheFilter) =>{
        //this.props.setSearchFilter(filter);
        this.props.setSearchFilter(cacheFilter);
    };

    reset = () =>{
         
        this.changeValue(originalData);
        this.props.setSearchFilter(originalData);
    }

    render(){
        const {airflowVal,maxPowerVal,soundVal,fanSweepVal} = this.props.searchFilter;
        //const {modelYear}=this.state.cacheFilter.modelYear ? this.state.cacheFilter.modelYear : this.props.searchFilter.modelYear;   //this is for model Year

        return (

        <div className="justify-content-center">
            <div>
                <span>
                    <button onClick={()=>{this.changeFilter(this.state.cacheFilter)}}>Save</button>
                </span>
                
                    <button onClick={()=>{ this.reset() }}>Reset</button>
                
            </div>
            
            
            {/*<div className="form-group">
                <label>Model Year </label>
                <input name="min-year" type="number" maxlength="4" minLength="4" placeholder={modelYear.min} onChange={(newMin)=> this.changeValue({ ...this.state.cacheFilter, modelYear:{min:newMin , max:modelYear.max} })}/>
                <input name="max-year" type="number" maxlength="4" minLength="4" placeholder={modelYear.max} onChange={(newMax)=> this.changeValue({ ...this.state.cacheFilter, modelYear:{min:modelYear.min, max:newMax} })}/>
        </div>*/ 
        }
            <div className="form-group">
                <label>Airflow <span>(CFM)</span></label>
                <RangeInput
                    maxValue={airflowVal.max}
                    minValue={airflowVal.min}
                    value={airflowVal}
                    changeValue={(airflowVal)=>this.changeValue({ ...this.state.cacheFilter, airflowVal })}/>
            </div>
            <div className="form-group">
                <label>Max Power <span>(W)</span></label>
                <RangeInput
                    maxValue={maxPowerVal.max}
                    minValue={maxPowerVal.min}
                    value={maxPowerVal}
                    changeValue={(maxPowerVal)=>this.changeValue({ ...this.state.cacheFilter, maxPowerVal })}/>
            </div>
            <div className="form-group">
                <label>Sound at max speed <span>(dBA)</span></label>
                <RangeInput
                    maxValue={soundVal.max}
                    minValue={soundVal.min}
                    value={soundVal}
                    changeValue={(soundVal)=>this.changeValue({ ...this.state.cacheFilter, soundVal })}/>            
            </div>
            <div className="form-group">
                <label>Fan sweep diameter <span>(in)</span></label>
                <RangeInput
                    maxValue={fanSweepVal.max}
                    minValue={fanSweepVal.min} 
                    value={fanSweepVal}
                    changeValue={(fanSweepVal)=>this.changeValue({ ...this.state.cacheFilter, fanSweepVal })}/>
            </div>


        </div>
        );
    }
    
  
}

const mapStateToProps = state => {
    return{
        searchFilter: state.product.searchFilter ? state.product.searchFilter : originalData
    }
 };

export default connect(mapStateToProps, {setSearchFilter, resetSearchFilter})(TechSpecs);
import React from 'react';
import './NavBar.css';
import '../../containers/search/search.css';
import SearchBar from '../../containers/search/searchBar';

const logo = "/pixelated-bird.png";

export const NavBar = (props) => {
    if(props.invisible && !props.loggedIn){    //if true first form for login w/ out signup
        return(
            <header className="header large-header">
                <div className="nav-link">
                    <span class="right">
                        {props.link==="login" ?<a href="/login">Login</a> : <a href="/signup">Sign up</a>}
                    </span>
                </div>
                <div className="low-center">
                    <div className="spacer"></div>
                        <img className="big-logo" src={logo} alt="joole logo"></img>
                        <p className="tag-line">Building Product Selection Platform</p>
                </div>
            </header>
        );
            
        
    }else if(props.invisible && props.loggedIn){
        return(
        <header className="header large-header">
            <div className="nav-link">
                <span class="right">
                    <div className="profile-img-container">
                            <img className="profile-img" src={props.loggedIn.image} alt="profile"/>
                    </div>
                </span>
            </div>
            <div className="low-center">
                <span class="center">
                    <img class="big-logo" src={logo} alt="joole logo"/>
                    <p class="tag-line">Joole Product Selection Platform</p>
                </span>
            </div>
        </header>
        );
    }
    return(
        <header className="header small-header">
            <div className="row">
                <div className="col-3"> 
                    <span class="left">
                        <a href="/"><img class="small-logo" src={logo} alt="joole logo"/></a>
                    </span>
                </div>

                <div className="col-6 align-self-center">
                    <SearchBar/>
                </div>

                <div class="col-3 align-self-center">
                    <div className="float-right profile-img-container">
                        <img className="profile-img" src={props.loggedIn.image} alt="profile"/>
                    </div>
                </div>
            </div>
        </header>
    );
    

};

export default NavBar;
import React, { Component } from 'react';
import { fb } from './config/fbConfig';
import {
    Route,
    BrowserRouter,
    Link,
    Redirect,
    Switch
} from 'react-router-dom';

import Login from './components/pages/publics/Login';
import Dashboard from './components/pages/privates/Dashboard';
import Home from './components/pages/publics/Home';

function logout () {
    return fb.auth().signOut();
}

function PrivateRoute ({component: Component, authed, ...rest}) {
    return (
        <Route
            {...rest}
            render={(props) => authed === true
                ? <Component {...props} />
                : <Redirect to={{pathname: '/login', state: {from: props.location}}} />}
        />
    )
}

function PublicRoute ({component: Component, authed, ...rest}) {
    return (
        <Route
            {...rest}
            render={(props) => authed === false
                ? <Component {...props} />
                : <Redirect to='/dashboard' />}
        />
    )
}

class App extends Component {
    state = {
        authed: false,
        loading: false,
        userId: "",
    };
    componentDidMount () {
        this.removeListener = fb.auth().onAuthStateChanged((user) => {
            if (user) {
                this.setState({
                    authed: true,
                    loading: false,
                    userId: user.uid,
                })
            } else {
                this.setState({
                    authed: false,
                    loading: false
                })
            }
        })
    }
    componentWillUnmount () {
        this.removeListener()
    }
    render() {
        return (
            <div className="App">
                <BrowserRouter>
                    <div>
                        <nav className="navbar navbar-expand-lg navbar-light bg-light" style={{ borderBottom: "2px solid #88CC2A"}}>
                            <div className="container">
                                <div className="navbar-header">
                                    <Link to="/" className="navbar-brand">
                                        <img src="https://firebasestorage.googleapis.com/v0/b/amstree-905e6.appspot.com/o/logoNoBG.png?alt=media&token=dd18c1e5-795c-4503-b4c9-cd6edcc53460" width="120" height="50" alt=""/>
                                    </Link>
                                </div>
                                <ul className="nav navbar-nav pull-right">
                                    <li>
                                        {this.state.authed
                                            ? <Link to="/dashboard" className="navbar-brand">Dashboard</Link>
                                            :<Link to="/dashboard" className="navbar-brand" style={{ display: "none" }}>Dashboard</Link>
                                        }
                                    </li>
                                    <li>
                                        {this.state.authed
                                            ?
                                            <div>
                                                <button
                                                    style={{border: 'none', background: 'transparent'}}
                                                    onClick={() => {
                                                        logout()
                                                    }}
                                                    className="navbar-brand">Logout</button>
                                            </div>
                                            : <span>
                                                <Link to="/login" className="navbar-brand">Login</Link>
                                            </span>
                                        }
                                    </li>
                                </ul>
                            </div>
                        </nav>
                        <div className="container-fluid">
                            <div className="row">
                                <Switch>
                                    <Route path='/' exact component={Home} />
                                    <PublicRoute authed={this.state.authed} path='/login' component={Login} />
                                    <PrivateRoute authed={this.state.authed} path='/dashboard' component={Dashboard} />
                                    <Route render={() => <h3>No Match</h3>} />
                                </Switch>
                            </div>
                        </div>
                    </div>
                </BrowserRouter>
            </div>
        );
    }
}

export default App;

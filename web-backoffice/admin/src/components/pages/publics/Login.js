import React, { Component } from 'react';
import { fb } from "../../../config/fbConfig";

function setErrorMsg(error) {
    return {
        loginMessage: error
    }
}

class Login extends Component {
    state = { loginMessage: null }
    handleSubmit = (e) => {
        e.preventDefault();
        fb.auth().signInWithEmailAndPassword(this.email.value, this.password.value)
            .catch((error) => {
                this.setState(setErrorMsg('Invalid username or password')
                )
            });
    }
    render() {
        return(
            <div className="col-sm-6 col-sm-offset-3" style={{
                padding: "15px",
                margin: "5% 10% 10% 23%"
            }}>
                <div className="card">
                    <div className="card-header" style={{ backgroundColor: "#88CC2A"}}>
                        <h5 style={{ color: "#ffffff" }}>Login</h5>
                    </div>
                    <div className="card-body">
                        <form onSubmit={this.handleSubmit}>
                            <div className="form-group">
                                <label>Email</label>
                                <input
                                    className="form-control"
                                    ref={(email) => this.email = email}
                                    placeholder="Email"/>
                            </div>
                            <div className="form-group">
                                <label>Password</label>
                                <input
                                    type="password"
                                    className="form-control"
                                    placeholder="Password"
                                    ref={(password) => this.password = password} />
                            </div>
                            {
                                this.state.loginMessage &&
                                <div className="alert alert-danger" role="alert">
                                    <span className="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                    <span className="sr-only">Error:</span>
                                    &nbsp;{this.state.loginMessage}
                                        <a href="#" onClick={this.resetPassword} className="alert-link">Forgot Password?</a>
                                </div>
                            }
                            <br />
                            <button type="submit" className="btn btn-primary"
                                    style={{
                                        backgroundColor: "#88CC2A",
                                        border: "none",
                                        width: "100%"
                                    }}>Login</button>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default Login;

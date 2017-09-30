import React, { Component } from 'react';
import { fb } from '../../../config/fbConfig';

class Home extends Component {
    componentDidMount () {
        this.removeListener = fb.auth().onAuthStateChanged((user) => {
            if (user) {
                window.location.href = '/dashboard';
            } else {
                window.location.href = '/login';
            }
        })
    }
    render() {
        return (
            <div className="Home">
                <div>Home</div>
            </div>
        );
    }
}

export default Home;

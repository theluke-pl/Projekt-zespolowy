import React, { Component } from 'react';
import withRoot from './withRoot'
import Layout from './Layout';

class App extends Component {
  render() {
    return (
      <Layout />
    );
  }
}

export default withRoot(App);

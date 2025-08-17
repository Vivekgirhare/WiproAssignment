import React, { Component } from "react";




class MenuItem extends Component {
  render() {
    const { name, price, category, available } = this.props;
    return (

        
      <div style={{ margin: "10px 0" }}>
        <p>
          <strong>{name}</strong> - ₹{price} ({category}), {available}
        </p>
      </div>
    );
  }
}

export default MenuItem;

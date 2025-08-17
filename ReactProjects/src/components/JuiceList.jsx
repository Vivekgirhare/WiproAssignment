import React from "react";
import Juice from "./Juice";

const JuiceList = () => {
  const juices = [
    { id: 1, name: "Orange Juice", price: 80 },
    { id: 2, name: "Apple Juice", price: 100 },
    { id: 3, name: "Mango Juice", price: 120 }
  ];


  
  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h2>Juice Menu</h2>
      <table border="1" style={{ margin: "0 auto", borderCollapse: "collapse", width: "50%" }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Juice Name</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {juices.map((juice) => (
            <Juice key={juice.id} id={juice.id} name={juice.name} price={juice.price} />
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default JuiceList;

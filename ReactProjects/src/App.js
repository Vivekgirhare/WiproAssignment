import React from "react";
import GroceryList from "./components/GroceryList";
import Car from "./components/Car";
import Phone from "./components/Phone";
import SweetsList from "./components/SweetsList";
import Electronics from "./components/Electronics";
import CanteenMenu from "./components/CanteenMenu";
import JuiceList from "./components/JuiceList";
import Restaurant from "./components/Restaurant";
import TempleList from "./components/TempleList";
import TailorShop from "./components/TailorShop";

function App() {
  const groceries = ["Rice", "Wheat", "Sugar", "Milk", "Oil"];

  return (
    <div style={{ textAlign: "center" }}>

      {/* Question 1: Grocery List */}
      <div style={{ border: "2px solid black", margin: "20px", padding: "10px" }}>

        <GroceryList items={groceries} />
      </div>

      {/* Question 2: Car Class Component */}
      <div style={{ border: "2px solid black", margin: "20px", padding: "10px" }}>
       
        <Car brand="Toyota" model="Fortuner" color="Black" year="2022" />
      </div>

      {/* Question 3: Phone Component */}
      <div style={{ border: "2px solid black", margin: "20px", padding: "10px" }}>
       
        <Phone />
      </div>

      {/* Question 4: Sweets List */}
      <div style={{ border: "2px solid black", margin: "20px", padding: "10px" }}>
       
        <SweetsList />
      </div>

      {/* Question 5: Electronics */}
      <div style={{ border: "2px solid black", margin: "20px", padding: "10px" }}>
       
        <Electronics />
      </div>

      {/* Question 6: Canteen Menu */}
      <div style={{ border: "2px solid black", margin: "20px", padding: "10px" }}>
       
        <CanteenMenu />
      </div>

      {/* Question 7: Juice Menu */}
      <div style={{ border: "2px solid black", margin: "20px", padding: "10px" }}>
        
        <JuiceList />
      </div>

      {/* Question 8: Restaurant Menu */}
      <div style={{ border: "2px solid black", margin: "20px", padding: "10px" }}>
        
        <Restaurant />
      </div>

      {/* Question 9: Temple List */}
<div style={{ border: "2px solid black", margin: "20px", padding: "10px" }}>
  
  <TempleList />
</div>



<div style={{ border: "2px solid black", margin: "20px", padding: "10px" }}>
 
  <TailorShop />
</div>


    </div>
  );
}

export default App;

// src/components/TailorShop.jsx
import React from "react";
import ServiceCard from "./ServiceCard";

function TailorShop() {
  // 1. Maintain array of JSON objects
  const tailoringServices = [


    {
      serviceName: "Shirt",
      price: 20,
      fabricsAvailable: ["Cotton", "Linen", "Polyester"]
    },


    
    {
      serviceName: "Pants",
      price: 30,
      fabricsAvailable: ["Denim", "Wool", "Chino"]
    },
    {
      serviceName: "Lehenga",
      price: 150,
      fabricsAvailable: ["Silk", "Georgette", "Chiffon"]
    },
    {
      serviceName: "Blouse",
      price: 40,
      fabricsAvailable: ["Cotton", "Silk", "Satin"]
    }
  ];

  return (
    <div className="container py-4">
      <h2 className="mb-4 text-center">Tailoring Services</h2>
      <div className="row">
        {tailoringServices.map((service, idx) => (
          <ServiceCard key={idx} service={service} />
        ))}
      </div>
    </div>
  );
}

export default TailorShop;

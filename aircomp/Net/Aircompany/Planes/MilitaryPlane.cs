using Aircompany.Models;

namespace Aircompany.Planes
{
    public class MilitaryPlane : Plane
    {
        private MilitaryType _planeType;

        public MilitaryPlane(string model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType planeType)
            : base(model, maxSpeed, maxFlightDistance, maxLoadCapacity)
        {
            _planeType = planeType;
        }

        public override bool Equals(object obj)
        {
            var plane = obj as MilitaryPlane;
            return plane != null &&
                   base.Equals(obj) &&
                   _planeType == plane._planeType;
        }

        public override int GetHashCode()
        {
            var hashCode = 1701194404;
            hashCode = hashCode * -1521134295 + base.GetHashCode();
            hashCode = hashCode * -1521134295 + _planeType.GetHashCode();
            return hashCode;
        }

        public MilitaryType GetPlaneType()
        {
            return _planeType;
        }


        public override string ToString()
        {
            return base.ToString().Replace("}",
                    ", type=" + _planeType +
                    '}');
        }        
    }
}

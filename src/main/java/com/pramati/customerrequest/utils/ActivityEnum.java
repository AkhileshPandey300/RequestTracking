package com.pramati.customerrequest.utils;

public enum ActivityEnum {
	OPEN {
		public String toString() {
			return "Open";
		}
	},
	PROGRESS {
		public String toString() {
			return "In Progress";
		}
	},

	REJECTED {
		public String toString() {
			return "Rejected";
		}
	},

	CLOSED {
		public String toString() {
			return "Closed";
		}
	}

}
